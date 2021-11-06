package kz.onggar.collector.service.user;

import kz.onggar.collector.entity.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity createUser(String steamId);

    UserEntity findUserById(UUID id);
}
