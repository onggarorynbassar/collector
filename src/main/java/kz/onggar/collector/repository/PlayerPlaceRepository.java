package kz.onggar.collector.repository;

import kz.onggar.collector.entity.PlayerPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerPlaceRepository extends JpaRepository<PlayerPlaceEntity, UUID> {
}
