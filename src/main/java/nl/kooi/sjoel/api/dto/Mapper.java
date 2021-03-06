package nl.kooi.sjoel.api.dto;


import nl.kooi.sjoel.domain.*;
import org.modelmapper.ModelMapper;

public class Mapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static Sjoelpunten map(SjoelpuntenDto sjoelpuntenDto) {
        return modelMapper.map(sjoelpuntenDto, Sjoelpunten.class);
    }

    public static Spel map(SpelDto spelDto) {
        return modelMapper.map(spelDto, Spel.class);
    }

    public static SpelDto map(Spel spel) {
        return modelMapper.map(spel, SpelDto.class);
    }

    public static Speler map(SpelerDto speler) {
        return modelMapper.map(speler, Speler.class);
    }

    public static SpelerDto map(Speler speler) {
        return modelMapper.map(speler, SpelerDto.class);
    }

    public static ScoreDto map(Score score) {
        return modelMapper.map(score, ScoreDto.class);
    }

    public static RondeDto map(Ronde ronde) {
        return modelMapper.map(ronde, RondeDto.class);
    }
}
