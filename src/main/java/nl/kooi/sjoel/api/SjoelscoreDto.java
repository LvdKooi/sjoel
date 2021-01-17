package nl.kooi.sjoel.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class SjoelscoreDto {
    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    private Integer scoresTwee;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    private Integer scoresDrie;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    private Integer scoresVier;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    private Integer scoresEen;
}
