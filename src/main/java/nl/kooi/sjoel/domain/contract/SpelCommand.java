package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.dao.SpelDao;

public interface SpelCommand {

    Spel execute(SpelDao spelDao);
}
