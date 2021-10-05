package kz.onggar.collector.service;


import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.PlayerPlaceEntity;
import kz.onggar.collector.mapper.MatchMapper;
import kz.onggar.collector.openapi.dto.Match;
import kz.onggar.collector.openapi.dto.MatchResult;
import kz.onggar.collector.openapi.dto.PlayerWithPlace;
import kz.onggar.collector.repository.MatchRepository;
import kz.onggar.collector.repository.PlayerPlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final PlayerPlaceRepository playerPlaceRepository;
    private final PlayerService playerService;

    public MatchServiceImpl(
            MatchRepository matchRepository,
            PlayerPlaceRepository playerPlaceRepository,
            PlayerService playerService
    ) {
        this.matchRepository = matchRepository;
        this.playerPlaceRepository = playerPlaceRepository;
        this.playerService = playerService;
    }

    @Override
    @Transactional
    public Match saveMatchResult(MatchResult matchResult) {
        MatchEntity matchEntity = matchRepository.save(new MatchEntity());

        var playersWithPlaces = matchResult.getPlayersWithPlaces();

        for (PlayerWithPlace playerWithPlace : playersWithPlaces) {
            PlayerPlaceEntity playerPlaceEntity = new PlayerPlaceEntity();
            if (playerWithPlace.getPlayerId() != null) {
                var foundPlayer = playerService.getPlayerEntityById(playerWithPlace.getPlayerId());
                playerPlaceEntity.setPlayer(foundPlayer);
            } else {
                var savedNewPlayer = playerService.createNewPlayer(playerWithPlace.getSteamId());
                playerPlaceEntity.setPlayer(savedNewPlayer);

            }
            playerPlaceEntity.setPlace(playerWithPlace.getPlace());

            var savedPlayerPlaceEntity = playerPlaceRepository.save(playerPlaceEntity);

            matchEntity.getPlayerPlaces().add(savedPlayerPlaceEntity);
        }

        return MatchMapper.toDto(matchEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Match> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(MatchMapper::toDto)
                .collect(Collectors.toList());
    }
}
