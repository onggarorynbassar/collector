package kz.onggar.collector.repository;

import kz.onggar.collector.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchResultRepository extends JpaRepository<MatchEntity, UUID> {

}
