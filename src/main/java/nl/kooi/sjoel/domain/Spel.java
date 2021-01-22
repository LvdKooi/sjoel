package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Spel {
    private int id;
    private Instant startmoment;
    private Set<Speler> spelers;
    private Map<Integer, Map<Speler, Integer>> scores = new HashMap<>();


    public void addScore(Integer ronde, Speler speler, Integer score) {
        var spelerScore = new HashMap<Speler, Integer>();
        spelerScore.put(speler, score);
        scores.merge(ronde, spelerScore, (map1, map2) -> scores.put(ronde, map2));
    }
}
