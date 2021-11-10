package kz.onggar.collector.repository;

import kz.onggar.collector.entity.NpcPackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NpcPackRepository extends JpaRepository<NpcPackEntity, UUID> {
}
