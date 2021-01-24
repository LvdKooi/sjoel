package nl.kooi.sjoel.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ronde")
public class RondeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rondenummer;
    @ManyToOne
    private SpelEntity spel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ronde")
    private Set<ScoreEntity> scores;
}
