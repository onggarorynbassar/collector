package kz.onggar.collector;

import kz.onggar.collector.component.LobbyPlayerCount;
import kz.onggar.collector.service.RelativeRatingCalculator;
import kz.onggar.collector.service.SimpleRatingCalculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled("ADIK NE SDELAL")
class SimpleRatingCalculatorTest {

    @Autowired
    private SimpleRatingCalculator simpleRatingCalculator;

    @Test
    void calculateNewRank() {
        assertEquals(10100, simpleRatingCalculator.calculateNewRank(10_000,  1, LobbyPlayerCount.COMMON));
        assertEquals(10075, simpleRatingCalculator.calculateNewRank(10_000,  2, LobbyPlayerCount.COMMON));
        assertEquals(10050, simpleRatingCalculator.calculateNewRank(10_000,  3, LobbyPlayerCount.COMMON));
        assertEquals(10025, simpleRatingCalculator.calculateNewRank(10_000,  4, LobbyPlayerCount.COMMON));
        assertEquals(9975, simpleRatingCalculator.calculateNewRank(10_000, 5, LobbyPlayerCount.COMMON));
        assertEquals(9950, simpleRatingCalculator.calculateNewRank(10_000, 6, LobbyPlayerCount.COMMON));
        assertEquals(9925, simpleRatingCalculator.calculateNewRank(10_000, 7, LobbyPlayerCount.COMMON));
        assertEquals(9900, simpleRatingCalculator.calculateNewRank(10_000, 8, LobbyPlayerCount.COMMON));
    }
}