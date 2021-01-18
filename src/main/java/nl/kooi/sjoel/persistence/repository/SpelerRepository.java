package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.SpelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpelerRepository extends JpaRepository<SpelerEntity, Integer> {
}
