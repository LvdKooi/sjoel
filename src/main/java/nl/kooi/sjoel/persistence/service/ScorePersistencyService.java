package nl.kooi.sjoel.persistence.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.dao.ScoreDao;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.domain.exception.OngeldigeSjoelActieException;
import nl.kooi.sjoel.persistence.ScoreEntity;
import nl.kooi.sjoel.persistence.repository.RondeRepository;
import nl.kooi.sjoel.persistence.repository.ScoreRepository;
import nl.kooi.sjoel.persistence.repository.SpelerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScorePersistencyService implements ScoreDao {

    private final SpelerRepository spelerRepository;
    private final ScoreRepository scoreRepository;
    private final RondeRepository rondeRepository;

    @Override
    public void submit(int spelerId, int spelId, int rondenummer, int score) {

        var spelerEntity = spelerRepository.findById(spelerId).orElseThrow(
                () -> new NotFoundException(String.format("De speler (id: %s) is niet gevonden.", spelerId))
        );
        var rondeEntity = rondeRepository.findBySpelIdAndRondenummer(spelId, rondenummer).orElseThrow(
                () -> new NotFoundException(String.format("De combinatie spel (id: %s) en rondenummer (%s) is niet gevonden.", spelId, rondenummer))
        );

        if(scoreRepository.findBySpelerIdAndRondeRondenummerAndRondeSpelId(spelerId, rondenummer, spelId).isPresent()) {
            throw new OngeldigeSjoelActieException(String.format("Er is in spel (id: %s) al een score voor speler %s " +
                    "in rondenummer (%s) bekend.", spelId, spelerEntity.getNaam(), rondenummer));
        }

        var scoreEntity = new ScoreEntity();

        scoreEntity.setScore(score);
        scoreEntity.setRonde(rondeEntity);
        scoreEntity.setSpeler(spelerEntity);

        scoreRepository.save(scoreEntity);

    }

    @Override
    public Score getScore(int spelerId, int spelId, int rondenummer) {
        return null;
    }
}
