package kz.onggar.collector.service.user;

import kz.onggar.collector.entity.UserEntity;

public interface UserService {
    UserEntity createUser(String steamId);
}
