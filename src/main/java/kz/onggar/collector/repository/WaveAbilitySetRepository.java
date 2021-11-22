package kz.onggar.collector.repository;

import kz.onggar.collector.entity.WaveAbilitySetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WaveAbilitySetRepository extends JpaRepository<WaveAbilitySetEntity, UUID> {
}
