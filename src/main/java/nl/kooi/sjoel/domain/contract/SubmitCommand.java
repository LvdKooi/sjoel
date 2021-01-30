package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.dao.ScoreDao;

public interface SubmitCommand<T> {

    void execute(ScoreDao scoreDao, CommandContext commandContext);
}
