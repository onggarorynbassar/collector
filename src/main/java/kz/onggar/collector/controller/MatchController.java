package kz.onggar.collector.controller;

import kz.onggar.collector.openapi.api.MatchesApi;
import kz.onggar.collector.openapi.dto.Match;
import kz.onggar.collector.openapi.dto.MatchResult;
import kz.onggar.collector.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController implements MatchesApi {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public ResponseEntity<Match> saveMatchResults(MatchResult matchResult) {
        return new ResponseEntity<>(matchService.saveMatchResult(matchResult), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }
}
