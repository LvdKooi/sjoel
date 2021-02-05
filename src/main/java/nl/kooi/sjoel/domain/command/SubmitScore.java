package nl.kooi.sjoel.domain.command;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.Sjoelpunten;
import nl.kooi.sjoel.domain.contract.CommandContext;
import nl.kooi.sjoel.domain.contract.SubmitScoreCommand;
import nl.kooi.sjoel.domain.dao.ScoreDao;
import nl.kooi.sjoel.domain.exception.SjoelpuntenException;


@RequiredArgsConstructor
public class SubmitScore implements SubmitScoreCommand {
    private final Sjoelpunten sjoelpunten;
    private int spelerId;
    private int rondenummer;
    private int spelId;

    public static SubmitScore metPunten(Sjoelpunten sjoelpunten) {
        return new SubmitScore(sjoelpunten);
    }

    public SubmitScore speler(int spelerId) {
        this.spelerId = spelerId;
        return this;
    }

    public SubmitScore spel(int spelId) {
        this.spelId = spelId;
        return this;
    }

    public SubmitScore ronde(int rondenummer) {
        this.rondenummer = rondenummer;
        return this;
    }


    @Override
    public Score execute(ScoreDao scoreDao,
                         CommandContext commandContext) {

        commandContext.getValidatorService().validate(sjoelpunten);

        var score = calculateScore(sjoelpunten);

        return scoreDao.submit(spelerId, spelId, rondenummer, score);

    }


    private int calculateScore(Sjoelpunten sjoelpunten) {
        var laagsteScore = sjoelpunten.getScoremap().values()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new SjoelpuntenException("De sjoelpunten bevatten velden zonder waarde.")
                );

        var totaalScore = laagsteScore * 20;

        totaalScore += sjoelpunten
                .getScoremap()
                .entrySet()
                .stream()
                .mapToInt(entry -> (entry.getValue() - laagsteScore) * entry.getKey()).sum();

        return totaalScore;
    }
}
