package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.contract.CommandContext;
import nl.kooi.sjoel.domain.contract.SubmitCommand;
import nl.kooi.sjoel.domain.dao.ScoreDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreDao scoreDao;
    private final CommandContext commandContext;

    @Transactional
    public void execute(SubmitCommand<?> submitCommand) {
        submitCommand.execute(scoreDao, commandContext);
    }

}
