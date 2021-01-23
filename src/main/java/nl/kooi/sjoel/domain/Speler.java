package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Speler {
    private int id;
    private String naam;
    private Spel spel;
    private List<Score> scores;
}
