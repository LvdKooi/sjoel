package nl.kooi.sjoel.api;

import lombok.Data;

import java.time.Instant;

@Data
public class SpelDto {
    private int id;
    private Instant startmoment;
}
