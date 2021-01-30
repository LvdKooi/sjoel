package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Score;

public interface ScoreDao {

    void submit(int spelerId, int spelId, int rondenummer, int score);

    Score getScore(int spelerId, int spelId, int rondenummer);
}
