package nl.kooi.sjoel.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "spel")
@ToString
@Getter
@Setter
public class SpelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant startmoment;

    @ManyToMany
    @JoinTable(name = "spel_speler", joinColumns = @JoinColumn(name = "spel_id"), inverseJoinColumns = @JoinColumn(name = "speler_id"))
    private Set<SpelerEntity> spelers;

}
