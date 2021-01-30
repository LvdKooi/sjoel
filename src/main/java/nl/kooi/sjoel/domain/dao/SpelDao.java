package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Spel;

public interface SpelDao {
    void saveSpel(Spel spel);

    Spel getSpel(int spelId);
}
