package kz.onggar.collector.service.match;

import kz.onggar.collector.openapi.dto.*;

import java.util.List;

public interface MatchService {
    MatchStart save(SteamIds ids);
    void update(MatchUpdate matchUpdate);
}
