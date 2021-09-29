package kz.onggar.collector.service;

import kz.onggar.collector.dto.Player;
import kz.onggar.collector.entity.PlayerEntity;
import kz.onggar.collector.mapper.PlayerMapper;
import kz.onggar.collector.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}