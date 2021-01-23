package nl.kooi.sjoel.persistence;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ronde")
public class RondeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rondeNummer;
    @ManyToOne
    private SpelEntity spel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ronde")
    private Set<ScoreEntity> scores;
}
