package nl.kooi.sjoel.domain;

import nl.kooi.sjoel.persistence.RondeEntity;
import nl.kooi.sjoel.persistence.ScoreEntity;
import nl.kooi.sjoel.persistence.SpelEntity;
import nl.kooi.sjoel.persistence.SpelerEntity;
import org.modelmapper.ModelMapper;

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
        return modelMapper.map(rondeEntity, Ronde.class);
    }

    public static RondeEntity map(Ronde ronde) {
        return modelMapper.map(ronde, RondeEntity.class);
    }


    public static Score map(ScoreEntity scoreEntity) {
        return modelMapper.map(scoreEntity, Score.class);
    }
}
