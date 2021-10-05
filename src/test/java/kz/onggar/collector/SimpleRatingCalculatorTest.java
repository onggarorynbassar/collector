package kz.onggar.collector;

import kz.onggar.collector.component.LobbyType;
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
        assertEquals(10100, simpleRatingCalculator.calculateNewRank(10_000,  1, LobbyType.COMMON));
        assertEquals(10075, simpleRatingCalculator.calculateNewRank(10_000,  2, LobbyType.COMMON));
        assertEquals(10050, simpleRatingCalculator.calculateNewRank(10_000,  3, LobbyType.COMMON));
        assertEquals(10025, simpleRatingCalculator.calculateNewRank(10_000,  4, LobbyType.COMMON));
        assertEquals(9975, simpleRatingCalculator.calculateNewRank(10_000, 5, LobbyType.COMMON));
        assertEquals(9950, simpleRatingCalculator.calculateNewRank(10_000, 6, LobbyType.COMMON));
        assertEquals(9925, simpleRatingCalculator.calculateNewRank(10_000, 7, LobbyType.COMMON));
        assertEquals(9900, simpleRatingCalculator.calculateNewRank(10_000, 8, LobbyType.COMMON));
    }
}