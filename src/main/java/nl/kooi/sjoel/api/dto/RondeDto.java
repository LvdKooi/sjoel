package nl.kooi.sjoel.api.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RondeDto {
    private int rondenummer;
    private Map<SpelerDto, ScoreDto> scores = new HashMap<>();
}
