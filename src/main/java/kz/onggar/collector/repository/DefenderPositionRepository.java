package kz.onggar.collector.repository;


import kz.onggar.collector.entity.DefenderEntity;
import kz.onggar.collector.entity.DefenderPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DefenderPositionRepository extends JpaRepository<DefenderPositionEntity, UUID> {
}
