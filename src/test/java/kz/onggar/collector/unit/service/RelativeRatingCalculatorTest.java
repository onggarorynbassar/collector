package kz.onggar.collector.unit.service;

import kz.onggar.collector.component.LobbyPlayerCount;
import kz.onggar.collector.service.RelativeRatingCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RelativeRatingCalculatorTest {

    @Autowired
    private RelativeRatingCalculator relativeRatingCalculator;

    @Test
    void calculateNewRank() {
        assertEquals(10089, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 1, LobbyPlayerCount.COMMON));
        assertEquals(10062, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 2, LobbyPlayerCount.COMMON));
        assertEquals(10036, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 3, LobbyPlayerCount.COMMON));
        assertEquals(10018, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 4, LobbyPlayerCount.COMMON));
        assertEquals(9987, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 5, LobbyPlayerCount.COMMON));
        assertEquals(9973, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 6, LobbyPlayerCount.COMMON));
        assertEquals(9953, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 7, LobbyPlayerCount.COMMON));
        assertEquals(9933, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 8, LobbyPlayerCount.COMMON));

        //TODO добавить еще тесты которые проверяют когда playerCurrentRating = 0, или когда avgOtherPlayersRating 30_000
    }
}