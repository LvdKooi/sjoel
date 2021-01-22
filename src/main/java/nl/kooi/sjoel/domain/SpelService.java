package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpelService {
    private final SpelRepository spelRepository;

    public void saveSpel(Spel spel) {
        spelRepository.save(Mapper.map(spel));
    }

}
