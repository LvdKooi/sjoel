package nl.kooi.sjoel.domain.command.score;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.GetMapQuery;
import nl.kooi.sjoel.domain.dao.ScoreDao;

import java.util.Map;


@RequiredArgsConstructor(staticName = "of")
public class GetTotaalScores implements GetMapQuery<Speler, Integer, ScoreDao> {

    private final int spelId;

    @Override
    public Map<Speler, Integer> get(ScoreDao scoreDao) {
        return scoreDao.getTotalScorePerPlayerInGame(spelId);
    }
}
