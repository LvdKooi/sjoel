package nl.kooi.sjoel.domain;

import nl.kooi.sjoel.persistence.SpelEntity;
import org.modelmapper.ModelMapper;

public class Mapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static SpelEntity map(Spel spel) {
       var mapped = modelMapper.map(spel, SpelEntity.class);
        System.out.println(mapped);
        return mapped;
    }
}
