package kz.onggar.collector.repository;


import kz.onggar.collector.entity.MercenarySpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MercenarySpellRepository extends JpaRepository<MercenarySpellEntity, UUID> {

    Optional<MercenarySpellEntity> findByName(String name);
}

