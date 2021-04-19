package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.dao.RondeDao;

public interface RondeCommand {

    void execute(RondeDao rondeDao);
}
