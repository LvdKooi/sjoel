package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Speler;

import java.util.List;

public interface SpelerDao {

    Speler saveSpeler(Speler speler);

    Speler findSpelerById(int spelerId);

    List<Speler> getSpelers();
}
