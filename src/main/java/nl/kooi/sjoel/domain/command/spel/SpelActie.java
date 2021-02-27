package nl.kooi.sjoel.domain.command.spel;

import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.contract.SpelCommand;

public abstract class SpelActie implements SpelCommand {

      public static SpelActie voegNieuwSpelToe(Spel spel) {
        return new NieuwSpelToevoegen(spel);
    }

    public static SpelActie updateBestaandspel(int spelerId, Spel spel) {
        return new SpelAanpassen(spel, spelerId);
    }
}
