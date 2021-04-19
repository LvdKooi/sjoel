package nl.kooi.sjoel.persistence.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.dao.SpelDao;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpelPersistencyService implements SpelDao {
    private final SpelRepository spelRepository;

    @Override
    public Spel saveSpel(Spel spel) {
        return Mapper.map(spelRepository.save(Mapper.map(spel)));
    }

    @Override
    public Spel getSpel(int spelId) {
        return spelRepository.findById(spelId).map(Mapper::map).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
    }
}
