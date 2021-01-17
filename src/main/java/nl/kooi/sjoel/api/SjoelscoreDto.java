package nl.kooi.sjoel.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SjoelscoreDto {
    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    @NotNull(message = "Vul een score in.")
    private Integer scoresTwee;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    @NotNull(message = "Vul een score in.")
    private Integer scoresDrie;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    @NotNull(message = "Vul een score in.")
    private Integer scoresVier;

    @Min(value = 0, message = "Scores kleiner dan 0 zijn niet mogelijk bij sjoelen.")
    @Max(value = 32, message = "Scores groter dan 32 zijn niet mogelijk bij sjoelen.")
    @NotNull(message = "Vul een score in.")
    private Integer scoresEen;
}
