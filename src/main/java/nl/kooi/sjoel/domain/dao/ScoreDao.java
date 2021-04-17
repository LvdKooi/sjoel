package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Score;
import nl.kooi.sjoel.domain.Speler;

import java.util.Map;

public interface ScoreDao {

    Score submit(int spelerId, int spelId, int rondenummer, int score);

    Score getScore(int spelerId, int spelId, int rondenummer);

    Map<Speler, Integer> getTotalScorePerPlayerInGame(int spelId);
}
