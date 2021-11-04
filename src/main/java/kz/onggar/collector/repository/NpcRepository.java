package kz.onggar.collector.repository;

import kz.onggar.collector.entity.NpcEntity;
import kz.onggar.collector.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NpcRepository extends JpaRepository<NpcEntity, UUID> {
    Optional<NpcEntity> findByName(String name);
}



