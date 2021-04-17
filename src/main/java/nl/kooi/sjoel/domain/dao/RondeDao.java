package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Ronde;

import java.util.List;

public interface RondeDao {

    Ronde saveVolgendeRonde(int spelId);

    Ronde getHuidigeRonde(int spelId);

    List<Ronde> getRondesInSpel(int spelId);

    void deleteLaatsteRonde(int spelId);
}
