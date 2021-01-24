package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.persistence.repository.RondeRepository;
import nl.kooi.sjoel.persistence.repository.SpelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RondeService {

    private final RondeRepository rondeRepository;
    private final SpelRepository spelRepository;

    public void saveRonde(int spelId, Ronde ronde) {
        var spelEntity =  spelRepository.findById(spelId).orElseThrow();
        var rondeEntity = Mapper.map(ronde);
        rondeEntity.setSpel(spelEntity);
        rondeRepository.save(rondeEntity);

    }

    public Ronde getRonde(int spelId, int rondeNummer) {
        return rondeRepository.findBySpelIdAndRondenummer(spelId, rondeNummer).map(Mapper::map).orElseThrow();
    }

}
