package nl.kooi.sjoel.persistence;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    @ManyToOne
    private RondeEntity ronde;
}
