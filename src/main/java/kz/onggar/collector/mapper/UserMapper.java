package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.openapi.dto.User;

public class UserMapper {
    public static User toDto(UserEntity userEntity) {
        return new User()
                .steamId(userEntity.steamId())
                .competitiveMmr(userEntity.competitiveRating())
                .relativeMmr(userEntity.relativeRating())
                .simpleMmr(userEntity.simpleRating())
                .id(userEntity.id());
    }

    public static UserEntity fromDto(User User) {
        return UserEntity.builder()
                .steamId(User.getSteamId())
                .competitiveRating(User.getCompetitiveMmr())
                .relativeRating(User.getRelativeMmr())
                .simpleRating(User.getSimpleMmr())
                .build();
    }

    public static UserEntity getUserEntityFromSteamId(String steamId) {
        return new UserEntity().steamId(steamId);
    }
}
