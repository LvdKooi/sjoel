package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Spel;

public interface SpelDao {
    Spel saveSpel(Spel spel);

    Spel getSpel(int spelId);
}
