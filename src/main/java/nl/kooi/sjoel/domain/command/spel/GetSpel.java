package nl.kooi.sjoel.domain.command.spel;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Spel;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.dao.SpelDao;


@RequiredArgsConstructor(staticName = "of")
public class GetSpel implements GetQuery<Spel, SpelDao> {

    private final int spelId;

    @Override
    public Spel get(SpelDao dao) {
        return dao.getSpel(spelId);
    }
}
