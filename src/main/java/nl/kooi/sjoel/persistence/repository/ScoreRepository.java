package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {

    Optional<ScoreEntity> findBySpelerIdAndRondeRondenummerAndRondeSpelId(int spelerId, int rondenummer, int spelId);
}
