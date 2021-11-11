package kz.onggar.collector.service.user;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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

    @Override
    @Transactional
    public Optional<UserEntity> getUserEntityBySteamId(String steamId) {
        return userRepository.findBySteamId(steamId);
    }

    @Override
    @Transactional
    public UserEntity findUserEntityById(UUID id) {
        return getUserEntityById(id).orElseThrow(
                () -> new ResourceNotFoundException("User entity with id=[%s] not found".formatted(id))
        );
    }

    @Override
    @Transactional
    public Optional<UserEntity> getUserEntityById(UUID id) {
        return userRepository.findById(id);
    }
}