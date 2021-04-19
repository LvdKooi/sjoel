package nl.kooi.sjoel.domain.command.speler;

import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.SpelerCommand;

public abstract class SpelerActie implements SpelerCommand {

      public static SpelerActie voegNieuweSpelerToe(Speler speler) {
        return new NieuweSpelerToevoegen(speler);
    }

    public static SpelerActie updateBestaandespeler(int spelerId, Speler speler) {
        return new SpelerAanpassen(speler, spelerId);
    }
}
