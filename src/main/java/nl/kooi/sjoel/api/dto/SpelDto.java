package nl.kooi.sjoel.api.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
public class SpelDto {
    private int id;
    private Instant startmoment;
    private Set<SpelerDto> spelers;
}
