package kz.onggar.collector.repository;


import kz.onggar.collector.entity.MercenaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MercenaryRepository extends JpaRepository<MercenaryEntity, UUID> {
}

