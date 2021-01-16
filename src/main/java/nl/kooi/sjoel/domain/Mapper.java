package nl.kooi.sjoel.domain;


import nl.kooi.sjoel.api.SjoelscoreDto;
import org.modelmapper.ModelMapper;

public class Mapper {
        private static ModelMapper modelMapper = new ModelMapper();

        public static Sjoelscore map(SjoelscoreDto sjoelscoreDto) {
                return modelMapper.map(sjoelscoreDto, Sjoelscore.class);
        }
}
