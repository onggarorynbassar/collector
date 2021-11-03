package kz.onggar.collector.service;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.openapi.dto.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(User User);

    UserEntity getUserEntityById(UUID id);

    User getUserById(UUID id);

    UserEntity createNewUser(String steamId);

    List<User> getAllUsers();

    User getUserBySteamId(String steamId);
}
