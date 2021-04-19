package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class Ronde {
    private int rondenummer;
    private Map<Speler, Score> scores = new HashMap<>();
}
