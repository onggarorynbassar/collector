package kz.onggar.collector.repository;

import kz.onggar.collector.entity.NpcAbilitySetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NpcAbilitySetRepository extends JpaRepository<NpcAbilitySetEntity, UUID> {
}



