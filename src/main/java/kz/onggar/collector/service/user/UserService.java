package kz.onggar.collector.service.user;

import kz.onggar.collector.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserEntity createUser(String steamId);
    Optional<UserEntity> getUserEntityBySteamId(String steamId);
    UserEntity findUserEntityById(UUID id);
    Optional<UserEntity> getUserEntityById(UUID id);
}
