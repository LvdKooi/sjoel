package nl.kooi.sjoel.domain.command.spel;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.dao.SpelDao;

@AllArgsConstructor
public class NieuwSpelToevoegen extends SpelActie {
    private Spel spel;

    @Override
    public Spel execute(SpelDao spelDao) {
        return spelDao.saveSpel(spel);
    }
}
