package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class Spel {
    private int id;
    private Instant startmoment;
    private Set<Speler> spelers;
}
