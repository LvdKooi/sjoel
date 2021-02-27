package nl.kooi.sjoel.persistence.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.dao.RondeDao;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.persistence.RondeEntity;
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
        var spelEntity = spelRepository.findById(spelId).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId))
        );
        var count = rondeRepository.countBySpelId(spelId);
        var rondeEntity = new RondeEntity();
        rondeEntity.setRondenummer(++count);
        rondeEntity.setSpel(spelEntity);
        rondeRepository.save(rondeEntity);
    }

    @Override
    public int getHuidigeRondenummer(int spelId) {
        spelRepository.findById(spelId).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
        var count = rondeRepository.countBySpelId(spelId);
        return rondeRepository
                .findBySpelIdAndRondenummer(spelId, count)
                .map(RondeEntity::getRondenummer)
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
}
