package kz.onggar.collector.repository;

import kz.onggar.collector.entity.DefenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DefenderRepository extends JpaRepository<DefenderEntity, UUID> {
    Optional<DefenderEntity> findByName(String name);
}
