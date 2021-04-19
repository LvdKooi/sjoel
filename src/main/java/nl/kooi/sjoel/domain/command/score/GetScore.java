package nl.kooi.sjoel.domain.command.score;

import lombok.AllArgsConstructor;
import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.contract.GetQuery;
import nl.kooi.sjoel.domain.dao.ScoreDao;


@AllArgsConstructor
public class GetScore implements GetQuery<Score, ScoreDao> {

    private int spelerId;
    private int rondenummer;
    private int spelId;

    public static GetScore ofSpeler(int spelerId){
        return new GetScore(spelerId, 0, 0);
    }

    public GetScore ronde(int rondenummer) {
        this.rondenummer = rondenummer;
        return this;
    }

    public GetScore spel(int spelId) {
        this.spelId = spelId;
        return this;
    }

    @Override
    public Score get(ScoreDao scoreDao) {
        return scoreDao.getScore(spelerId,spelId,rondenummer);
    }
}
