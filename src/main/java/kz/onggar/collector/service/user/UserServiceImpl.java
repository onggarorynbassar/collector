package kz.onggar.collector.service.user;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserEntity createUser(String steamId) {
        return userRepository.save(
                new UserEntity()
                        .steamId(steamId)
        );
    }
}