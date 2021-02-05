package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpelService {
    private final SpelRepository spelRepository;

    public Spel saveSpel(Spel spel) {
        return Mapper.map(spelRepository.save(Mapper.map(spel)));
    }

    public Spel getSpel(int spelId) {
        return spelRepository.findById(spelId).map(Mapper::map).orElseThrow(
                () -> new NotFoundException(String.format("Spel met id %s is niet gevonden.", spelId)));
    }
}
