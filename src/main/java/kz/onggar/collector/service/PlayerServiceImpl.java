package kz.onggar.collector.service;

import kz.onggar.collector.entity.PlayerEntity;
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
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setSteamId(player.getSteamId());
        playerEntity.setCompetitiveRating(player.getCompetitiveMmr());
        playerEntity.setRelativeRating(player.getRelativeMmr());
        playerEntity.setSimpleRating(player.getSimpleMmr());
        PlayerEntity savedEntity = playerRepository.save(playerEntity);
        return PlayerMapper.toDto(savedEntity);
    }

    @Override
    @Transactional
    public PlayerEntity getPlayerEntityById(UUID id) {
        return playerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Player getPlayerById(UUID id) {
        return PlayerMapper.toDto(
                playerRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new)
        );
    }

    @Override
    @Transactional
    public PlayerEntity createNewPlayer(String steamId) {
        var playerEntity = new PlayerEntity();
        playerEntity.setSteamId(steamId);
        return playerRepository.save(playerEntity);
    }

    @Override
    @Transactional
    public List<Player> getAllPlayers() {
        return playerRepository.findAll().stream().map(PlayerMapper::toDto).toList();
    }
}