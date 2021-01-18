package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {
}
