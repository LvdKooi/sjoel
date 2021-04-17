package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.RondeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RondeRepository extends JpaRepository<RondeEntity, Integer> {
    Optional<RondeEntity> findBySpelIdAndRondenummer(int spelId, int rondeNummer);

    List<RondeEntity> findBySpelId(int spelId);

    int countBySpelId(int spelId);
}
