package nl.kooi.sjoel.domain.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.CommandContext;
import nl.kooi.sjoel.domain.contract.GetMapQuery;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.contract.SubmitScoreCommand;
import nl.kooi.sjoel.domain.dao.ScoreDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreDao scoreDao;
    private final CommandContext commandContext;

    @Transactional
    public Score execute(SubmitScoreCommand submitScoreCommand) {
        return submitScoreCommand.execute(scoreDao, commandContext);
    }

    public Score get(GetQuery<Score, ScoreDao> getQuery) {
        return getQuery.get(scoreDao);
    }

    public Map<Speler, Integer> get(GetMapQuery<Speler, Integer, ScoreDao> getMapQuery) {
        return getMapQuery.get(scoreDao);
    }
}
