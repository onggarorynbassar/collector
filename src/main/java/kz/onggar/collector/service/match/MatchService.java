package kz.onggar.collector.service.match;

import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.MatchUpdate;
import kz.onggar.collector.openapi.dto.SteamIds;

import java.util.UUID;

public interface MatchService {
    MatchStart save(SteamIds ids);

    void update(MatchUpdate matchUpdate);

    MatchEntity getMatchEntity(UUID id);
}
