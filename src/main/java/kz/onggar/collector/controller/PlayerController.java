package kz.onggar.collector.controller;

import kz.onggar.collector.openapi.api.PlayersApi;
import kz.onggar.collector.openapi.dto.Player;
import kz.onggar.collector.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PlayerController implements PlayersApi {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public ResponseEntity<Player> createNewPlayer(@RequestBody Player player) {
        var savedPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @Override
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @Override
    public ResponseEntity<Player> getPlayerById(UUID id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }
}
