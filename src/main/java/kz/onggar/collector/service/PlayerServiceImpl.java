package kz.onggar.collector.service;

import kz.onggar.collector.entity.PlayerEntity;
import kz.onggar.collector.exception.AlreadyExistException;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.mapper.PlayerMapper;
import kz.onggar.collector.openapi.dto.Player;
import kz.onggar.collector.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public Player createPlayer(Player player) {
        checkIfPlayerWithSteamIdExists(player.getSteamId());

        var playerEntity = PlayerMapper.fromDto(player);
        PlayerEntity savedEntity = playerRepository.save(playerEntity);
        return PlayerMapper.toDto(savedEntity);
    }

    @Override
    @Transactional
    public PlayerEntity getPlayerEntityById(UUID id) {
        return playerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Player with id=[%s] not found".formatted(id))
        );
    }

    @Override
    @Transactional
    public Player getPlayerById(UUID id) {
        return PlayerMapper.toDto(
                getPlayerEntityById(id)
        );
    }

    @Override
    @Transactional
    public PlayerEntity createNewPlayer(String steamId) {
        var playerEntity = PlayerMapper.getPlayerEntityFromSteamId(steamId);
        return playerRepository.save(playerEntity);
    }

    @Override
    @Transactional
    public List<Player> getAllPlayers() {
        return playerRepository.findAll().stream().map(PlayerMapper::toDto).toList();
    }

    @Override
    @Transactional
    public Player getPlayerBySteamId(String steamId) {
        return PlayerMapper.toDto(
                playerRepository
                        .findBySteamId(steamId)
                        .orElseThrow(RuntimeException::new)
        );
    }

    /**
     * Use inside @Transactional method
     */
    private void checkIfPlayerWithSteamIdExists(String steamId) {
        if (playerRepository.existsBySteamId(steamId)) {
            throw new AlreadyExistException("player with steamId:[%s] exists".formatted(steamId));
        }
    }
}