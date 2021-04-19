package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.SpelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpelRepository extends JpaRepository<SpelEntity, Integer> {
}
