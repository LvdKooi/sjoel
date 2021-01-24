package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Ronde {
    private int rondenummer;
    private Map<Speler, Score> scores;
}
