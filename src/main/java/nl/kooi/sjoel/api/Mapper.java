package nl.kooi.sjoel.api;


import nl.kooi.sjoel.domain.Sjoelscore;
import nl.kooi.sjoel.domain.Spel;
import org.modelmapper.ModelMapper;

public class Mapper {
        private static ModelMapper modelMapper = new ModelMapper();

        public static Sjoelscore map(SjoelscoreDto sjoelscoreDto) {
                return modelMapper.map(sjoelscoreDto, Sjoelscore.class);
        }

        public static Spel map(SpelDto spelDto) {
                return modelMapper.map(spelDto, Spel.class);
        }
}
