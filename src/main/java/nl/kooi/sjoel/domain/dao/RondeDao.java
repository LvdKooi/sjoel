package nl.kooi.sjoel.domain.dao;

public interface RondeDao {

    void saveVolgendeRonde(int spelId);

    int getHuidigeRondenummer(int spelId);

    void deleteLaatsteRonde(int spelId);
}
