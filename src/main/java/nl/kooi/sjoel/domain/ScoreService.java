package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.domain.exception.SjoelpuntenException;
import nl.kooi.sjoel.persistence.ScoreEntity;
import nl.kooi.sjoel.persistence.repository.RondeRepository;
import nl.kooi.sjoel.persistence.repository.ScoreRepository;
import nl.kooi.sjoel.persistence.repository.SpelerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final RondeRepository rondeRepository;
    private final SpelerRepository spelerRepository;
    private final ValidatorService validatorService;

    public void submitPunten(int spelerId, int spelId, int rondenummer, Sjoelpunten sjoelpunten) {
        validatorService.validate(sjoelpunten);

        var score = calculateScore(sjoelpunten);
        var spelerEntity = spelerRepository.findById(spelerId).orElseThrow(
                () -> new NotFoundException(String.format("De speler (id: %s) is niet gevonden.", spelerId))
        );
        var rondeEntity = rondeRepository.findBySpelIdAndRondenummer(spelId, rondenummer).orElseThrow(
                () -> new NotFoundException(String.format("De combinatie speler (id: %s) en rondenummer (%s) is niet gevonden.", spelId, rondenummer))
        );

        var scoreEntity = new ScoreEntity();

        scoreEntity.setScore(score);
        scoreEntity.setRonde(rondeEntity);
        scoreEntity.setSpeler(spelerEntity);

        scoreRepository.save(scoreEntity);
    }

    private int calculateScore(Sjoelpunten sjoelpunten) {
        var laagsteScore = sjoelpunten.getScoremap().values()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new SjoelpuntenException("De sjoelscore bevatten punten zonder waarde.")
                );

        var totaalScore = laagsteScore * 20;

        totaalScore += sjoelpunten
                .getScoremap()
                .entrySet()
                .stream()
                .mapToInt(entry -> (entry.getValue() - laagsteScore) * entry.getKey()).sum();

        return totaalScore;
    }

    public Score getScore(int spelerId, int spelId, int rondenummer) {
        return scoreRepository
                .findBySpelerIdAndRondeRondenummerAndRondeSpelId(spelerId, rondenummer, spelId)
                .map(Mapper::map)
                .orElseThrow(() -> new NotFoundException(String.format("De combinatie spel (id: %s), speler (id: %s) en rondenummer (%s) is niet gevonden.", spelId, spelerId, rondenummer)));
    }
}
