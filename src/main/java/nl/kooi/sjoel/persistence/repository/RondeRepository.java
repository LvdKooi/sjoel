package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.RondeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RondeRepository extends JpaRepository<RondeEntity, Integer> {
}
