package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;
import nl.kooi.sjoel.domain.validation.SamenNietMeerDan;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SamenNietMeerDan(max = 32, velden = {"scoresEen", "scoresTwee", "scoresDrie", "scoresVier"})
public class Sjoelpunten {
    public static final int MAX_PUNTEN = 32;
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

    public Map<Integer, Integer> getScoremap() {
        var scoreMap = new HashMap<Integer, Integer>();
        scoreMap.put(2, scoresTwee);
        scoreMap.put(3, scoresDrie);
        scoreMap.put(4, scoresVier);
        scoreMap.put(1, scoresEen);

        return scoreMap;
    }
}
