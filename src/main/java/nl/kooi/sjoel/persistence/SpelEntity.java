package nl.kooi.sjoel.persistence;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "spel")
public class SpelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant startmoment;
}
