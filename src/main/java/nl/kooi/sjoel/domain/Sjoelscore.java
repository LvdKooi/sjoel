package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Sjoelscore {

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

    public Map<Integer, Integer> getScoremap() {
        var scoreMap = new HashMap<Integer, Integer>();
        scoreMap.put(2, scoresTwee);
        scoreMap.put(3, scoresDrie);
        scoreMap.put(4, scoresVier);
        scoreMap.put(1, scoresEen);

        return scoreMap;
    }
}
