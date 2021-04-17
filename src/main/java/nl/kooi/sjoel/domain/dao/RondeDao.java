package nl.kooi.sjoel.domain.dao;

import nl.kooi.sjoel.domain.Ronde;

public interface RondeDao {

    void saveVolgendeRonde(int spelId);

    int getHuidigeRondenummer(int spelId);

    Ronde getHuidigeRonde(int spelId);

    void deleteLaatsteRonde(int spelId);
}
