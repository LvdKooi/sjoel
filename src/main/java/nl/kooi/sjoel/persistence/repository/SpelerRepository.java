package nl.kooi.sjoel.persistence.repository;

import nl.kooi.sjoel.persistence.SpelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpelerRepository extends JpaRepository<SpelerEntity, Integer> {

    public Optional<SpelerEntity> findBySpelIdAndId(int spelId, int spelerId);

    public List<SpelerEntity> findAllBySpelId(int spelId);

}
