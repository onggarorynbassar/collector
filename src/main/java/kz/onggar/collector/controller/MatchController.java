package kz.onggar.collector.controller;

import kz.onggar.collector.openapi.api.MatchesApi;
import kz.onggar.collector.openapi.dto.MatchResult;
import kz.onggar.collector.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MatchController implements MatchesApi {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public ResponseEntity<UUID> saveMatchResults(MatchResult matchResult) {
        matchService.saveMatchResult(matchResult);
        return ResponseEntity.ok().build();
    }
}
