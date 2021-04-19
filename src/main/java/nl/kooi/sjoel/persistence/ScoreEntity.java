package nl.kooi.sjoel.persistence;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "score")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @ManyToOne
    private SpelerEntity speler;
    private int score;
    @ManyToOne
    private RondeEntity ronde;
}
