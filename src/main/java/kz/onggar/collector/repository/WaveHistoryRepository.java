package kz.onggar.collector.repository;

import kz.onggar.collector.entity.WaveHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WaveHistoryRepository extends JpaRepository<WaveHistoryEntity, UUID> {

}
