package nl.kooi.sjoel.persistence.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.dao.SpelerDao;
import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.persistence.repository.SpelerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpelerPersistencyService implements SpelerDao {

    private final SpelerRepository spelerRepository;

    @Override
    public Speler saveSpeler(Speler speler) {
        return Mapper.map(spelerRepository.save(Mapper.map(speler)));

    }

    @Override
    public Speler findSpelerById(int spelerId) {
        return spelerRepository.findById(spelerId).map(Mapper::map).orElseThrow(
                () -> new NotFoundException(String.format("Speler met id %s is niet gevonden.", spelerId))
        );
    }

    @Override
    public List<Speler> getSpelers() {
        return spelerRepository.findAll().stream().map(Mapper::map).collect(Collectors.toList());
    }
}
