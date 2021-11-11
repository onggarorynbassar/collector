package kz.onggar.collector.repository;

import kz.onggar.collector.entity.WaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WaveRepository extends JpaRepository<WaveEntity, UUID> {
    Optional<WaveEntity> findByRoundNumber(int roundNumber);
}
