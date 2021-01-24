package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpelService {
    private final SpelRepository spelRepository;

    public void saveSpel(Spel spel) {
        spelRepository.save(Mapper.map(spel));
    }

    public Spel getSpel(int id) {
        return spelRepository.findById(id).map(Mapper::map).orElseThrow();
    }
}