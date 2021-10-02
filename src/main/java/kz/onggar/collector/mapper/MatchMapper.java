package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.openapi.dto.Match;

public class MatchMapper {
    public static Match toDto(MatchEntity matchEntity) {
        Match match = new Match();
        match.setId(matchEntity.getId());
        return match;
    }
}
