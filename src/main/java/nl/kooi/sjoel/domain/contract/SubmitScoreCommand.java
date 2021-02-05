package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.dao.ScoreDao;

public interface SubmitScoreCommand {

    Score execute(ScoreDao scoreDao, CommandContext commandContext);
}
