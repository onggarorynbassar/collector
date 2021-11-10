package kz.onggar.collector.repository;


import kz.onggar.collector.entity.UserWaveMercenaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface UserWaveMercenaryRepository extends JpaRepository<UserWaveMercenaryEntity, UUID> {

}
