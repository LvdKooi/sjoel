package nl.kooi.sjoel.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spel")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SpelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private Instant startmoment;

    @ManyToMany
    @JoinTable(name = "spel_speler", joinColumns = @JoinColumn(name = "spel_id"), inverseJoinColumns = @JoinColumn(name = "speler_id"))
    private Set<SpelerEntity> spelers = new HashSet<>();

}
