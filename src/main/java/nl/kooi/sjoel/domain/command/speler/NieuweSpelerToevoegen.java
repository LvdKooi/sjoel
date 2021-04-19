package nl.kooi.sjoel.domain.command.speler;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.dao.SpelerDao;

@AllArgsConstructor
public class NieuweSpelerToevoegen extends SpelerActie {
    private Speler speler;

    @Override
    public Speler execute(SpelerDao spelerDao) {
        return spelerDao.saveSpeler(speler);
    }
}
