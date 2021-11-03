package kz.onggar.collector.controller;

import kz.onggar.collector.openapi.api.MatchesApi;
import kz.onggar.collector.openapi.dto.*;
import kz.onggar.collector.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class MatchController implements MatchesApi {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public ResponseEntity<MatchStart> saveMatch(@Valid SteamIds steamIds) {
        return ResponseEntity.ok(matchService.save(steamIds));
    }

    @Override
    public ResponseEntity<Void> updateMatch(@Valid MatchUpdate matchUpdate) {
        return null;
    }
}
