package nl.kooi.sjoel.domain.command.spel;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.dao.SpelDao;

@AllArgsConstructor
public class SpelAanpassen extends SpelActie {
    private Spel spel;
    private int spelId;

    @Override
    public Spel execute(SpelDao spelDao) {
        spelDao.getSpel(spelId);
        spel.setId(spelId);
        return spelDao.saveSpel(spel);
    }
}
