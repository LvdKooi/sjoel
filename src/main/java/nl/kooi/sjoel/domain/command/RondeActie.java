package nl.kooi.sjoel.domain.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nl.kooi.sjoel.domain.contract.RondeCommand;

@AllArgsConstructor
@Getter
public abstract class RondeActie implements RondeCommand {

    private int spelId;

    public static RondeActie volgendeRonde(int spelId) {
        return new VolgendeRonde(spelId);
    }

    public static RondeActie verwijderLaatsteRonde(int spelId) {
        return new VerwijderLaatsteRonde(spelId);
    }

}
