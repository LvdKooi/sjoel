package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.RondeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RondeRepository extends JpaRepository<RondeEntity, Integer> {
}
