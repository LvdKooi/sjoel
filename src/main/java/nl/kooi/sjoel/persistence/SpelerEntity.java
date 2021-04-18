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
@Table(name = "speler")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SpelerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String naam;

    @ManyToMany(mappedBy = "spelers")
    private Set<SpelEntity> spellen = new HashSet<>();
}
