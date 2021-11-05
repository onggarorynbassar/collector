package kz.onggar.collector.service.match;


import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.mapper.UserMapper;
import kz.onggar.collector.openapi.dto.*;
import kz.onggar.collector.repository.MatchRepository;
import kz.onggar.collector.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    @Transactional
    public MatchStart save(SteamIds ids) {
        var newMatch = matchRepository.save(new MatchEntity());

        List<User> foundOrCreatedUsers = ids.getSteamIds()
                .stream()
                .map(steamId ->
                        userRepository.findBySteamId(steamId)
                                .orElseGet(() -> userRepository.save(new UserEntity().steamId(steamId)))
                )
                .map(UserMapper::toDto)
                .collect(Collectors.toList());

        return new MatchStart()
                .match(new Match().id(newMatch.id()))
                .users(foundOrCreatedUsers);
    }

    @Transactional(readOnly = true)
    public MatchEntity getMatchEntity(UUID id) {
        return matchRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Match entity with id=[%s] not found".formatted(id))
        );
    }

    @Override
    @Transactional
    public void update(MatchUpdate matchUpdate) {
        var matchEntity = getMatchEntity(matchUpdate.getUserMatchStatus().getId());
        matchEntity.currentWave(matchUpdate.getWave());
        
    }
}
