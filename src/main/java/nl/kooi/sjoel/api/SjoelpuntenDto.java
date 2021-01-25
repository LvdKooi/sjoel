package nl.kooi.sjoel.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SjoelpuntenDto {
    private Integer scoresTwee;
    private Integer scoresDrie;
    private Integer scoresVier;
    private Integer scoresEen;
}
