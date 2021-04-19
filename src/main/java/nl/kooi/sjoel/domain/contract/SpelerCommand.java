package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.dao.SpelerDao;

public interface SpelerCommand {

    Speler execute(SpelerDao spelerDao);
}
