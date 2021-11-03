package kz.onggar.collector.service;


import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.mapper.UserMapper;
import kz.onggar.collector.openapi.dto.*;
import kz.onggar.collector.repository.MatchRepository;
import kz.onggar.collector.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    public MatchServiceImpl(
            MatchRepository matchRepository,
            UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    /**
     * Получает SteamID
     * Проверяет есть ил он в SteamID
     * Если есть вытаскиваем
     * Если нет то создать
     * Вернуть в формате, в котором просят
     */
    @Override
    @Transactional
    public MatchStart save(SteamIds ids) {
        // Создаём образ MatchStart который будем наполнять
        var matchStart = new MatchStart();

        // Создаём новый матч
        var startedMatch = matchRepository.save(new MatchEntity());
        var startedMatchDto = new Match();

        // Используем DTO, т.к мы получили объект из БД, ставим айдишник
        startedMatchDto.setId(startedMatch.id());

        // Лист в котором хранятся все игроки, найденные и не найденные все лежат тут
        List<User> users = new ArrayList<>();

        /*
        Проходимся по списку steamId, ищем есть ли такой игрок в нашей БД, если есть просто переводим в DTO
        полученное из бд значение. Иначе создаём и так же переводим в DTO
        */

        for (String steamId : ids.getSteamIds()) {
            var foundUser = userRepository.findBySteamId(steamId);

            if (foundUser.isEmpty()) {
                var savedUser = userRepository.save(new UserEntity().steamId(steamId));
                users.add(UserMapper.toDto(savedUser));
            } else {
                users.add(UserMapper.toDto(foundUser.get()));
            }
        }
        matchStart.setMatch(startedMatchDto);
        matchStart.setUsers(users);

        return matchStart;
    }

    @Override
    @Transactional
    public void update(MatchUpdate matchUpdate) {

    }
//    @Override
//    @Transactional
//    public Match saveMatchResult(MatchResult matchResult) {
//        MatchEntity matchEntity = matchRepository.save(new MatchEntity());
//
//        var UsersWithPlaces = matchResult.getUsersWithPlaces();
//
//        for (UserWithPlace UserWithPlace : UsersWithPlaces) {
//            UserPlaceEntity UserPlaceEntity = new UserPlaceEntity();
//            if (UserWithPlace.getUserId() != null) {
//                var foundUser = UserService.getUserEntityById(UserWithPlace.getUserId());
//                UserPlaceEntity.User(foundUser);
//            } else {
//                var savedNewUser = UserService.createNewUser(UserWithPlace.getSteamId());
//                UserPlaceEntity.User(savedNewUser);
//
//            }
//            UserPlaceEntity.place(UserWithPlace.getPlace());
//
//            var savedUserPlaceEntity = UserPlaceRepository.save(UserPlaceEntity);
//
//            matchEntity.UserPlaces().add(savedUserPlaceEntity);
//        }
//
//        return MatchMapper.toDto(matchEntity);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Match> getAllMatches() {
//        return matchRepository.findAll()
//                .stream()
//                .map(MatchMapper::toDto)
//                .collect(Collectors.toList());
//    }
}
