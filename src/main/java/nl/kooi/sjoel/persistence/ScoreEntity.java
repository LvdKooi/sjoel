package nl.kooi.sjoel.persistence;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private SpelEntity speler;
    private int score;
    private int ronde;
}
