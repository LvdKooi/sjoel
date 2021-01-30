package nl.kooi.sjoel.persistence.service;

import nl.kooi.sjoel.domain.Speler;
import nl.kooi.sjoel.domain.dao.SpelerDao;

import java.util.List;

public class SpelerPersistencyService implements SpelerDao {
    @Override
    public void saveSpeler(Speler speler) {

    }

    @Override
    public Speler findSpelerById(int spelerId) {
        return null;
    }

    @Override
    public List<Speler> getSpelers() {
        return null;
    }
}
