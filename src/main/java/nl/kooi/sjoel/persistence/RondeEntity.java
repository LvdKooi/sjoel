package nl.kooi.sjoel.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ronde")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RondeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private int rondenummer;
    @ManyToOne
    private SpelEntity spel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ronde")
    private Set<ScoreEntity> scores = new HashSet<>();
}
