package nl.kooi.sjoel.domain.command.ronde;

import nl.kooi.sjoel.domain.dao.RondeDao;

public class VerwijderLaatsteRonde extends RondeActie{

    public VerwijderLaatsteRonde(int spelId) {
        super(spelId);
    }

    @Override
    public void execute(RondeDao rondeDao) {
        rondeDao.deleteLaatsteRonde(super.getSpelId());
    }

}
