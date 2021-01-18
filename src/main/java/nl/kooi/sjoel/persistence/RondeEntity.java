package nl.kooi.sjoel.persistence;

import javax.persistence.*;

@Entity
@Table(name = "ronde")
public class RondeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int nummer;
    @ManyToOne
    private SpelEntity spel;
}
