package nl.kooi.sjoel.api;


import nl.kooi.sjoel.api.dto.ScoreDto;
import nl.kooi.sjoel.api.dto.SjoelpuntenDto;
import nl.kooi.sjoel.api.dto.SpelDto;
import nl.kooi.sjoel.api.dto.SpelerDto;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.Sjoelpunten;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.Speler;
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
}
