package nl.kooi.sjoel.domain.command.speler;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.dao.SpelerDao;

@AllArgsConstructor
public class SpelerAanpassen extends SpelerActie {
    private Speler speler;
    private int spelerId;

    @Override
    public Speler execute(SpelerDao spelerDao) {
        spelerDao.findSpelerById(spelerId);
        speler.setId(spelerId);
        return spelerDao.saveSpeler(speler);
    }
}
