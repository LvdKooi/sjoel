package nl.kooi.sjoel.domain.command.speler;

import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.contract.GetListQuery;
import nl.kooi.sjoel.domain.dao.SpelerDao;

import java.util.List;


public class GetSpelers implements GetListQuery<Speler, SpelerDao> {

    @Override
    public List<Speler> get(SpelerDao dao) {
        return dao.getSpelers();
    }
}
