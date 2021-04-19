package nl.kooi.sjoel.api.dto;

import nl.kooi.sjoel.domain.Ronde;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.Speler;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapperTest {

    private static final Instant STARTMOMENT = Instant.now();

    @Test
    void mapSpel() {
        var spelerDto = new SpelerDto();
        var spelDto = new SpelDto();

        spelerDto.setId(1);
        spelerDto.setNaam("Laurens");

        spelDto.setId(1);
        spelDto.setStartmoment(STARTMOMENT);
        spelDto.setSpelers(Set.of(spelerDto));

        var spel = Mapper.map(spelDto);

        assertThat(spel.getId()).isEqualTo(1);
        assertThat(spel.getStartmoment()).isEqualTo(STARTMOMENT);
        assertThat(spel.getSpelers()).isNotNull();
        assertThat(spel.getSpelers().size()).isEqualTo(1);
        assertTrue(spel.getSpelers().stream().allMatch(speler -> speler.equals(makeSpeler())));
    }

    @Test
    void mapSpelDto() {
        var spel = new Spel();
        spel.setId(1);
        spel.setStartmoment(STARTMOMENT);
        spel.setSpelers(Set.of(makeSpeler()));

        var expectedSpelerDto = new SpelerDto();
        expectedSpelerDto.setId(1);
        expectedSpelerDto.setNaam("Laurens");

        var spelDto = Mapper.map(spel);

        assertThat(spelDto.getId()).isEqualTo(1);
        assertThat(spelDto.getStartmoment()).isEqualTo(STARTMOMENT);
        assertThat(spelDto.getSpelers()).isNotNull();
        assertThat(spelDto.getSpelers().size()).isEqualTo(1);
        assertTrue(spelDto.getSpelers().stream().allMatch(speler -> speler.equals(expectedSpelerDto)));

    }

    @Test
    void mapSpeler() {
        var spelerDto = new SpelerDto();
        spelerDto.setId(1);
        spelerDto.setNaam("Laurens");

        var speler = Mapper.map(spelerDto);

        assertThat(speler).isEqualTo(makeSpeler());
    }

    @Test
    void mapSpelerDto() {
        var expectedSpelerDto = new SpelerDto();
        expectedSpelerDto.setId(1);
        expectedSpelerDto.setNaam("Laurens");

        var spelerDto = Mapper.map(makeSpeler());

        assertThat(spelerDto).isEqualTo(expectedSpelerDto);
    }

    @Test
    void mapSjoelpunten() {

        var sjoelpuntenDto = new SjoelpuntenDto();
        sjoelpuntenDto.setScoresEen(1);
        sjoelpuntenDto.setScoresTwee(2);
        sjoelpuntenDto.setScoresDrie(3);
        sjoelpuntenDto.setScoresVier(4);

        var sjoelpunten = Mapper.map(sjoelpuntenDto);

        assertThat(sjoelpunten.getScoresEen()).isEqualTo(1);
        assertThat(sjoelpunten.getScoresTwee()).isEqualTo(2);
        assertThat(sjoelpunten.getScoresDrie()).isEqualTo(3);
        assertThat(sjoelpunten.getScoresVier()).isEqualTo(4);

    }

    @Test
    void mapScoreDto() {
        var scoreDto = Mapper.map(makeScore());
        assertThat(scoreDto.getScore()).isEqualTo(10);
        assertThat(scoreDto.getId()).isEqualTo(1);
    }

    @Test
    void mapRondeDto() {
        var ronde = new Ronde();
        ronde.setRondenummer(1);
        ronde.setScores(Map.of(makeSpeler(), makeScore()));

        var rondeDto = Mapper.map(ronde);

        assertThat(rondeDto.getRondenummer()).isEqualTo(1);
        assertThat(rondeDto.getScores()).isEqualTo(Map.of(Mapper.map(makeSpeler()), Mapper.map(makeScore())));
    }

    private Speler makeSpeler() {
        var speler = new Speler();
        speler.setId(1);
        speler.setNaam("Laurens");
        return speler;
    }

    private Score makeScore() {
        var score = new Score();
        score.setScore(10);
        score.setId(1);
        return score;
    }


}