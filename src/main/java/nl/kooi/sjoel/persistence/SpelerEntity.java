package nl.kooi.sjoel.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "speler")
public class SpelerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;

    @ManyToMany(mappedBy = "spelers")
    private Set<SpelEntity> spellen;
}
