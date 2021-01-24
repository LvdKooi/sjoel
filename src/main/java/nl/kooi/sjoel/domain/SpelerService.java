package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.persistence.repository.SpelerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SpelerService {
    private final SpelerRepository spelerRepository;


    public void saveSpeler(Speler speler) {
        spelerRepository.save(Mapper.map(speler));
    }

    public Speler findSpelerById(int spelerId) {
        return spelerRepository.findById(spelerId).map(Mapper::map).orElseThrow();
    }

    public List<Speler> getSpelers() {
        return spelerRepository.findAll().stream().map(Mapper::map).collect(Collectors.toList());
    }
}
