package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@ToString
public class Spel {
    private int id;
    private Instant startmoment;
    private Set<Speler> spelers;
}
