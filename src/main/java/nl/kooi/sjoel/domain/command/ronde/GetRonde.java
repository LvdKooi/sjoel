package nl.kooi.sjoel.domain.command.ronde;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Ronde;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.dao.RondeDao;


@AllArgsConstructor
public class GetRonde implements GetQuery<Ronde, RondeDao> {

    private int spelId;

    public static GetRonde huidigeInSpel(int spelId){
        return new GetRonde(spelId);
    }

    @Override
    public Ronde get(RondeDao rondeDao) {
        return rondeDao.getHuidigeRonde(spelId);
    }
}
