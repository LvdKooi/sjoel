package nl.kooi.sjoel.domain;

import nl.kooi.sjoel.persistence.RondeEntity;
import nl.kooi.sjoel.persistence.ScoreEntity;
import nl.kooi.sjoel.persistence.SpelEntity;
import nl.kooi.sjoel.persistence.SpelerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Pair;

import java.util.stream.Collectors;

public class Mapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static SpelEntity map(Spel spel) {
        return modelMapper.map(spel, SpelEntity.class);
    }

    public static Spel map(SpelEntity spelEntity) {
        return modelMapper.map(spelEntity, Spel.class);
    }

    public static Speler map(SpelerEntity spelerEntity) {
        return modelMapper.map(spelerEntity, Speler.class);
    }

    public static SpelerEntity map(Speler speler) {
        return modelMapper.map(speler, SpelerEntity.class);
    }

    public static Ronde map(RondeEntity rondeEntity) {
        var ronde = modelMapper.map(rondeEntity, Ronde.class);
        var scores = rondeEntity.getScores()
                .stream()
                .map(scoreEntity -> Pair.of(Mapper.map(scoreEntity.getSpeler()), Mapper.map(scoreEntity)))
                .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
        ronde.setScores(scores);
        return ronde;
    }

    public static RondeEntity map(Ronde ronde) {
        var rondeEntity = modelMapper.map(ronde, RondeEntity.class);
        var scoreEntities = ronde.getScores().entrySet()
                .stream()
                .map(entry -> new ScoreEntity(entry.getValue().getId(),
                        Mapper.map(entry.getKey()),
                        entry.getValue().getScore(),
                        rondeEntity))
                .collect(Collectors.toSet());
        rondeEntity.setScores(scoreEntities);
        return rondeEntity;
    }

    public static Score map(ScoreEntity scoreEntity) {
        return modelMapper.map(scoreEntity, Score.class);
    }

}
