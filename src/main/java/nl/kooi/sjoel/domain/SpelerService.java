package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import nl.kooi.sjoel.persistence.repository.SpelerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpelerService {
    private final SpelerRepository spelerRepository;
    private final SpelRepository spelRepository;

    @Transactional
    public Speler getSpelerBySpelIdAndSpelerId(int spelId, int spelerId) {
        return spelerRepository.findBySpelIdAndId(spelId, spelerId).map(Mapper::map).orElseThrow();
    }

    @Transactional
    public List<Speler> getSpelersBySpelId(int spelId) {
        return spelerRepository.findAllBySpelId(spelId).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Transactional
    public void addSpelerToSpel(int spelId, Speler speler) {
        var spelEntity = spelRepository.findById(spelId).orElseThrow();
        var spelerEntity = Mapper.map(speler);
        spelerEntity.setSpel(spelEntity);
        spelerRepository.save(spelerEntity);
    }
}
