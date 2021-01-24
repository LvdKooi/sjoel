package nl.kooi.sjoel.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private SpelerEntity speler;
    private int score;
    @ManyToOne
    private RondeEntity ronde;
}
