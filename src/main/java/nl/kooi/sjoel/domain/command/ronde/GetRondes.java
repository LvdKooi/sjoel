package nl.kooi.sjoel.domain.command.ronde;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Ronde;
import nl.kooi.sjoel.domain.contract.GetListQuery;
import nl.kooi.sjoel.domain.dao.RondeDao;

import java.util.List;


@RequiredArgsConstructor(staticName = "of")
public class GetRondes implements GetListQuery<Ronde, RondeDao> {

    private final int spelId;

    @Override
    public List<Ronde> get(RondeDao dao) {
        return dao.getRondesInSpel(spelId);
    }
}
