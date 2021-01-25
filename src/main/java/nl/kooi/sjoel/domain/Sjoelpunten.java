package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Sjoelpunten {
    public static final int MAX_PUNTEN = 32;
    private Integer scoresTwee;
    private Integer scoresDrie;
    private Integer scoresVier;
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
