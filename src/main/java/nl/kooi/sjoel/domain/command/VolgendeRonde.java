package nl.kooi.sjoel.domain.command;

import nl.kooi.sjoel.domain.dao.RondeDao;

public class VolgendeRonde extends RondeActie{

    public VolgendeRonde(int spelId) {
        super(spelId);
    }

    @Override
    public void execute(RondeDao rondeDao) {
        rondeDao.saveVolgendeRonde(super.getSpelId());
    }

}
