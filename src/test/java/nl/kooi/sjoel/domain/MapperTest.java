package nl.kooi.sjoel.domain;

import nl.kooi.sjoel.persistence.RondeEntity;
import nl.kooi.sjoel.persistence.ScoreEntity;
import nl.kooi.sjoel.persistence.SpelEntity;
import nl.kooi.sjoel.persistence.SpelerEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapperTest {

    private static final Instant STARTMOMENT = Instant.now();

    @Test
    void mapSpeler() {
        var expectedSpeler = new Speler();
        expectedSpeler.setId(1);
        expectedSpeler.setNaam("Laurens");

        var speler = Mapper.map(makeSpelerEntity());

        assertThat(speler).isEqualTo(expectedSpeler);
    }

    @Test
    void mapSpelerEntity() {
        var speler = new Speler();
        speler.setId(1);
        speler.setNaam("Laurens");

        var spelerEntity = Mapper.map(speler);

        assertThat(spelerEntity).isEqualTo(makeSpelerEntity());
    }

    @Test
    void mapSpel() {
        var expectedSpeler = new Speler();
        expectedSpeler.setId(1);
        expectedSpeler.setNaam("Laurens");

        var spel = Mapper.map(makeSpelEntity());

        assertThat(spel.getId()).isEqualTo(1);
        assertThat(spel.getStartmoment()).isEqualTo(STARTMOMENT);
        assertThat(spel.getSpelers()).isNotNull();
        assertThat(spel.getSpelers().size()).isEqualTo(1);
        assertTrue(spel.getSpelers().stream().allMatch(speler -> speler.equals(expectedSpeler)));
    }

    @Test
    void mapSpelEntity() {
        var speler = new Speler();
        var spel = new Spel();

        speler.setId(1);
        speler.setNaam("Laurens");

        spel.setId(1);
        spel.setStartmoment(STARTMOMENT);
        spel.setSpelers(Set.of(speler));

        var spelEntity = Mapper.map(spel);
        assertThat(spelEntity.getId()).isEqualTo(1);
        assertThat(spelEntity.getStartmoment()).isEqualTo(STARTMOMENT);
        assertThat(spelEntity.getSpelers()).isNotNull();
        assertThat(spelEntity.getSpelers().size()).isEqualTo(1);
        assertTrue(spelEntity.getSpelers().stream().allMatch(spelerEntity -> spelerEntity.equals(makeSpelerEntity())));
    }

    @Test
    void mapRonde() {
        var rondeEntity = new RondeEntity();
        rondeEntity.setRondenummer(1);
        rondeEntity.setScores(Set.of(makeScoreEntity()));

        var expectedSpeler = new Speler();
        expectedSpeler.setId(1);
        expectedSpeler.setNaam("Laurens");

        var ronde = Mapper.map(rondeEntity);

        assertThat(ronde.getRondenummer()).isEqualTo(1);
        assertThat(ronde.getScores().size()).isEqualTo(1);
        assertTrue(ronde.getScores().containsKey(expectedSpeler));
        assertThat(ronde.getScores().get(expectedSpeler).getId()).isEqualTo(1);
        assertThat(ronde.getScores().get(expectedSpeler).getScore()).isEqualTo(10);
    }

    @Test
    void mapRondeEntity() {
        var ronde = new Ronde();
        ronde.setRondenummer(1);
        ronde.setScores(Map.of(Mapper.map(makeSpelerEntity()), Mapper.map(makeScoreEntity())));

        var rondeEntity = Mapper.map(ronde);

        assertThat(rondeEntity.getRondenummer()).isEqualTo(1);
        assertThat(rondeEntity.getScores().size()).isEqualTo(1);
        assertTrue(rondeEntity.getScores().stream().allMatch(scoreEntity -> scoreEntity.getSpeler().getId() == 1));
    }

    @Test
    void mapScore() {
        var score = Mapper.map(makeScoreEntity());
        assertThat(score.getScore()).isEqualTo(10);
        assertThat(score.getId()).isEqualTo(1);
    }


    private SpelerEntity makeSpelerEntity() {
        var spelerEntity = new SpelerEntity();
        spelerEntity.setId(1);
        spelerEntity.setNaam("Laurens");
        spelerEntity.setSpellen(Collections.emptySet());
        return spelerEntity;
    }

    private ScoreEntity makeScoreEntity() {
        return new ScoreEntity(1, makeSpelerEntity(), 10, null);
    }

    private SpelEntity makeSpelEntity() {
        var spelEntity = new SpelEntity();
        spelEntity.setId(1);
        spelEntity.setStartmoment(STARTMOMENT);
        spelEntity.setSpelers(Set.of(makeSpelerEntity()));
        return spelEntity;

    }
}