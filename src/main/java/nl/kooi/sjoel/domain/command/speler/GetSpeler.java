package nl.kooi.sjoel.domain.command.speler;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.dao.SpelerDao;


@RequiredArgsConstructor(staticName = "of")
public class GetSpeler implements GetQuery<Speler, SpelerDao> {

    private final int spelerId;

    @Override
    public Speler get(SpelerDao dao) {
        return dao.findSpelerById(spelerId);
    }
}
