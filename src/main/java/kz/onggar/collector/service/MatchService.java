package kz.onggar.collector.service;

import kz.onggar.collector.openapi.dto.MatchResult;

public interface MatchService {
    void saveMatchResult(MatchResult matchResult);
}
