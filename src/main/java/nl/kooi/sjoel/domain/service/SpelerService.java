package nl.kooi.sjoel.domain.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.command.speler.GetSpeler;
import nl.kooi.sjoel.domain.command.speler.GetSpelers;
import nl.kooi.sjoel.domain.contract.SpelerCommand;
import nl.kooi.sjoel.domain.dao.SpelerDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SpelerService {
    private final SpelerDao spelerDao;

    @Transactional
    public Speler execute(SpelerCommand spelerCommand) {
        return spelerCommand.execute(spelerDao);
    }

    public Speler get(GetSpeler getSpeler) {
        return getSpeler.get(spelerDao);
    }

    public List<Speler> get(GetSpelers getSpelers) {
        return getSpelers.get(spelerDao);
    }

}
