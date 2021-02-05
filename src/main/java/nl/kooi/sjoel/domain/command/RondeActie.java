package nl.kooi.sjoel.domain.command;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.contract.RondeCommand;
import nl.kooi.sjoel.domain.dao.RondeDao;

@AllArgsConstructor
public class RondeActie implements RondeCommand {

    private int spelId;
    private boolean verwijderen;

    public static RondeActie volgendeRonde(int spelId) {
        return new RondeActie(spelId, false);

    }

    public static RondeActie verwijderLaatsteRonde(int spelId) {
        return new RondeActie(spelId, true);
    }

    @Override
    public void execute(RondeDao rondeDao) {
        if (verwijderen) {
            rondeDao.deleteLaatsteRonde(spelId);
        } else {
            rondeDao.saveVolgendeRonde(spelId);
        }
    }
}
