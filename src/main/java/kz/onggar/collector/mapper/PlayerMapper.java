package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.PlayerEntity;
import kz.onggar.collector.openapi.dto.Player;

public class PlayerMapper {

    public static Player toDto(PlayerEntity playerEntity) {
        Player player = new Player();

        player.setSteamId(playerEntity.getSteamId());
        player.setCompetitiveMmr(playerEntity.getCompetitiveRating());
        player.setRelativeMmr(playerEntity.getRelativeRating());
        player.setSimpleMmr(playerEntity.getSimpleRating());
        player.setId(playerEntity.getId());

        return player;
    }
}
