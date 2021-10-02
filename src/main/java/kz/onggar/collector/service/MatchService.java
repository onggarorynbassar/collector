package kz.onggar.collector.service;

import kz.onggar.collector.openapi.dto.Match;
import kz.onggar.collector.openapi.dto.MatchResult;

import java.util.List;

public interface MatchService {
    void saveMatchResult(MatchResult matchResult);

    List<Match> getAllMatches();
}
