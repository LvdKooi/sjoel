package nl.kooi.sjoel.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class SjoelscoreDto {
    @Min(0)
    @Max(32)
    private int scoresTwee;

    @Min(0)
    @Max(32)
    private int scoresDrie;

    @Min(0)
    @Max(32)
    private int scoresVier;

    @Min(0)
    @Max(32)
    private int scoresEen;
}
