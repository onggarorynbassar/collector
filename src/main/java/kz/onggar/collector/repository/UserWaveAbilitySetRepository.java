package kz.onggar.collector.repository;

import kz.onggar.collector.entity.UserWaveAbilitySetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserWaveAbilitySetRepository extends JpaRepository<UserWaveAbilitySetEntity, UUID> {
}
