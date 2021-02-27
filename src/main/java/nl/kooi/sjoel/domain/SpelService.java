package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.command.spel.GetSpel;
import nl.kooi.sjoel.domain.contract.SpelCommand;
import nl.kooi.sjoel.domain.dao.SpelDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpelService {
    private final SpelDao spelDao;

    @Transactional
    public Spel execute(SpelCommand spelCommand) {
        return spelCommand.execute(spelDao);
    }

    public Spel get(GetSpel getSpel) {
        return getSpel.get(spelDao);
    }
}
