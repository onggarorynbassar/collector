package kz.onggar.collector.service;

import kz.onggar.collector.dto.Player;
import kz.onggar.collector.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerService {

    Player createPlayer(Player player);

    PlayerEntity findPlayerById(UUID id);

    PlayerEntity saveNewPlayer(String steamId);
}
