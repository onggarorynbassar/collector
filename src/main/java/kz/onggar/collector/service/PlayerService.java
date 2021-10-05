package kz.onggar.collector.service;

import kz.onggar.collector.entity.PlayerEntity;
import kz.onggar.collector.openapi.dto.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    Player createPlayer(Player player);

    PlayerEntity getPlayerEntityById(UUID id);

    Player getPlayerById(UUID id);

    PlayerEntity createNewPlayer(String steamId);

    List<Player> getAllPlayers();

    Player getPlayerBySteamId(String steamId);
}
