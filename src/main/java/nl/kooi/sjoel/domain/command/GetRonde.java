package nl.kooi.sjoel.domain.command;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.dao.RondeDao;


@AllArgsConstructor
public class GetRonde implements GetQuery<Integer, RondeDao> {

    private int spelId;

    public static GetRonde huidigeInSpel(int spelId){
        return new GetRonde(spelId);
    }

    @Override
    public Integer get(RondeDao rondeDao) {
        return rondeDao.getHuidigeRondenummer(spelId);
    }
}
