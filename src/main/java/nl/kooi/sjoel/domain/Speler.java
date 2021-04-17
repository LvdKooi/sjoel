package nl.kooi.sjoel.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "naam")
public class Speler {
    private int id;
    private String naam;
}
