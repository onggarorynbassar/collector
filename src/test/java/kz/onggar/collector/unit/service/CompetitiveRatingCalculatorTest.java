package kz.onggar.collector.unit.service;

import kz.onggar.collector.component.LobbyPlayerCount;
import kz.onggar.collector.service.CompetitiveRatingCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompetitiveRatingCalculatorTest {

    @Autowired
    private CompetitiveRatingCalculator competitiveRatingCalculator;

    @Test
    void calculateNewRank() {
        assertEquals(10100, competitiveRatingCalculator.calculateNewRank(10_000,  1, LobbyPlayerCount.COMMON));
        assertEquals(10070, competitiveRatingCalculator.calculateNewRank(10_000,  2, LobbyPlayerCount.COMMON));
        assertEquals(10025, competitiveRatingCalculator.calculateNewRank(10_000,  3, LobbyPlayerCount.COMMON));
        assertEquals(10000, competitiveRatingCalculator.calculateNewRank(10_000,  4, LobbyPlayerCount.COMMON));
        assertEquals(9975, competitiveRatingCalculator.calculateNewRank(10_000, 5, LobbyPlayerCount.COMMON));
        assertEquals(9950, competitiveRatingCalculator.calculateNewRank(10_000, 6, LobbyPlayerCount.COMMON));
        assertEquals(9925, competitiveRatingCalculator.calculateNewRank(10_000, 7, LobbyPlayerCount.COMMON));
        assertEquals(9900, competitiveRatingCalculator.calculateNewRank(10_000, 8, LobbyPlayerCount.COMMON));
    }
}