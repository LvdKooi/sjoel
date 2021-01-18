package nl.kooi.sjoel.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Spel {
    private UUID id;
    private LocalDateTime startmoment;
    private int aantalRondes;
    private Map<Integer, Map<Speler, Integer>> scores = new HashMap<>();


    public void addScore(Integer ronde, Speler speler, Integer score) {
        var spelerScore = new HashMap<Speler, Integer>();
        spelerScore.put(speler, score);
        scores.merge(ronde, spelerScore, (map1, map2) -> scores.put(ronde, map2));
    }
}
