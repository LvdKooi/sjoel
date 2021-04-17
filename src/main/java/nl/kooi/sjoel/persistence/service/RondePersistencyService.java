package nl.kooi.sjoel.persistence.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.Ronde;
import nl.kooi.sjoel.domain.dao.RondeDao;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.domain.exception.OngeldigeSjoelActieException;
import nl.kooi.sjoel.persistence.RondeEntity;
import nl.kooi.sjoel.persistence.SpelEntity;
import nl.kooi.sjoel.persistence.repository.RondeRepository;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RondePersistencyService implements RondeDao {
    private final RondeRepository rondeRepository;
    private final SpelRepository spelRepository;

    @Override
    public void saveVolgendeRonde(int spelId) {
        var spelEntity = spelRepository.findById(spelId).orElseThrow(() -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
        var count = rondeRepository.countBySpelId(spelId);

        if (!canAdvanceToNextRound(spelEntity, count)) {
            throw new OngeldigeSjoelActieException("Het is niet mogelijk om een nieuwe ronde aan te maken: nog niet alle spelers hebben een score in de huidige ronde!");
        }

        var rondeEntity = new RondeEntity();
        rondeEntity.setRondenummer(++count);
        rondeEntity.setSpel(spelEntity);
        rondeRepository.save(rondeEntity);
    }

    @Override
    public int getHuidigeRondenummer(int spelId) {
        return getHuidigeRonde(spelId).getRondenummer();
    }

    @Override
    public Ronde getHuidigeRonde(int spelId) {
        spelRepository.findById(spelId).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
        var count = rondeRepository.countBySpelId(spelId);
        return rondeRepository
                .findBySpelIdAndRondenummer(spelId, count)
                .map(Mapper::map)
                .orElseThrow(() -> new NotFoundException(String.format("Spel met id %s heeft nog geen rondes.", spelId)));
    }

    @Override
    public void deleteLaatsteRonde(int spelId) {
        spelRepository.findById(spelId).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
        var count = rondeRepository.countBySpelId(spelId);
        var rondeEntity = rondeRepository.findBySpelIdAndRondenummer(spelId, count);
        rondeEntity.ifPresent(entity -> rondeRepository.deleteById(entity.getId()));

    }

    private boolean canAdvanceToNextRound(SpelEntity spelEntity, int currentRoundNumber) {

        if (currentRoundNumber != 0) {
            var spelers = spelEntity.getSpelers();
            var huidigeRonde = getHuidigeRonde(spelEntity.getId());
            return spelers
                    .stream()
                    .map(Mapper::map)
                    .allMatch(speler -> huidigeRonde.getScores().containsKey(speler) &&
                            huidigeRonde.getScores().get(speler) != null);
        }

        return true;
    }
}
