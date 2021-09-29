package kz.onggar.collector.controller;

import kz.onggar.collector.dto.MatchResult;
import kz.onggar.collector.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<String> saveMatchResult(@RequestBody MatchResult matchResult) {
        matchService.saveMatchResult(matchResult);
        return ResponseEntity.ok("Works");
    }
}
