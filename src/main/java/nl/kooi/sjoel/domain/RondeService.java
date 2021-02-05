package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.contract.RondeCommand;
import nl.kooi.sjoel.domain.dao.RondeDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RondeService {

    private final RondeDao rondeDao;

    @Transactional
    public void execute(RondeCommand rondeCommand) {
        rondeCommand.execute(rondeDao);
    }

    public Integer get(GetQuery<Integer, RondeDao> getQuery) {
        return getQuery.get(rondeDao);
    }

}
