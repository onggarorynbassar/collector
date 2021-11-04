package kz.onggar.collector.service;

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


    //    @Override
//    @Transactional
//    public User createUser(User User) {
//        checkIfUserWithSteamIdExists(User.getSteamId());
//
//        var UserEntity = UserMapper.fromDto(User);
//        UserEntity savedEntity = userRepository.save(UserEntity);
//        return UserMapper.toDto(savedEntity);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserEntity getUserEntityById(UUID id) {
//        return userRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("User with id=[%s] not found".formatted(id))
//        );
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getUserById(UUID id) {
//        return UserMapper.toDto(
//                getUserEntityById(id)
//        );
//    }
//
//    @Override
//    @Transactional
//    public UserEntity createNewUser(String steamId) {
//        var UserEntity = UserMapper.getUserEntityFromSteamId(steamId);
//        return userRepository.save(UserEntity);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> getAllUsers() {
//        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getUserBySteamId(String steamId) {
//        return UserMapper.toDto(
//                userRepository
//                        .findBySteamId(steamId)
//                        .orElseThrow(RuntimeException::new)
//        );
//    }
//
//    /**
//     * Use inside @Transactional method
//     */
//    private void checkIfUserWithSteamIdExists(String steamId) {
//        if (userRepository.existsBySteamId(steamId)) {
//            throw new AlreadyExistException("User with steamId:[%s] exists".formatted(steamId));
//        }
//    }
}