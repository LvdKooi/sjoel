package nl.kooi.sjoel.domain.service;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Ronde;
import nl.kooi.sjoel.domain.contract.GetListQuery;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.contract.RondeCommand;
import nl.kooi.sjoel.domain.dao.RondeDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RondeService {

    private final RondeDao rondeDao;

    @Transactional
    public void execute(RondeCommand rondeCommand) {
        rondeCommand.execute(rondeDao);
    }

    public Ronde get(GetQuery<Ronde, RondeDao> getQuery) {
        return getQuery.get(rondeDao);
    }

    public List<Ronde> get(GetListQuery<Ronde, RondeDao> getQuery) {
        return getQuery.get(rondeDao);
    }

}
