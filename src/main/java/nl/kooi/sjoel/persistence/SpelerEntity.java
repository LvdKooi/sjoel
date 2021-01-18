package nl.kooi.sjoel.persistence;

import javax.persistence.*;

@Entity
@Table(name = "speler")
public class SpelerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    @ManyToOne
    private SpelEntity spel;
}
