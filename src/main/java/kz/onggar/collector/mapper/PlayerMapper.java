package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.PlayerEntity;
import kz.onggar.collector.openapi.dto.Player;

public class PlayerMapper {
    public static Player toDto(PlayerEntity playerEntity) {
        return new Player()
                .steamId(playerEntity.steamId())
                .competitiveMmr(playerEntity.competitiveRating())
                .relativeMmr(playerEntity.relativeRating())
                .simpleMmr(playerEntity.simpleRating())
                .id(playerEntity.id());
    }

    public static PlayerEntity fromDto(Player player) {
        return PlayerEntity.builder()
                .steamId(player.getSteamId())
                .competitiveRating(player.getCompetitiveMmr())
                .relativeRating(player.getRelativeMmr())
                .simpleRating(player.getSimpleMmr())
                .build();
    }

    public static PlayerEntity getPlayerEntityFromSteamId(String steamId) {
        return new PlayerEntity().steamId(steamId);
    }
}
