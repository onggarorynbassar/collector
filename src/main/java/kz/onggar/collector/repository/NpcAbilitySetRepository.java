package kz.onggar.collector.repository;

import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.entity.NpcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NpcAbilitySetRepository extends JpaRepository<NpcAbilitySetEntity, UUID> {
    Optional<NpcAbilitySetEntity> findByNpc_IdAndOption(UUID npcId, int option);
}



