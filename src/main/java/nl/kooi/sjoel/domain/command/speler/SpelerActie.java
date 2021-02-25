package nl.kooi.sjoel.domain.command.speler;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.SpelerCommand;
import nl.kooi.sjoel.domain.dao.SpelerDao;

@AllArgsConstructor
public class SpelerActie implements SpelerCommand {

    private Speler speler;
    private int spelerId;

    public static SpelerActie voegNieuweSpelerToe(Speler speler) {
        return new SpelerActie(speler, 0);
    }

    public static SpelerActie updateBestaandespeler(int spelerId, Speler speler) {
        return new SpelerActie(speler, spelerId);
    }

    @Override
    public Speler execute(SpelerDao spelerDao) {
        if (spelerId != 0) {
            spelerDao.findSpelerById(spelerId);
            speler.setId(spelerId);
        }

        return spelerDao.saveSpeler(speler);
    }
}
