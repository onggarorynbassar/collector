package kz.onggar.collector;

import kz.onggar.collector.component.LobbyType;
import kz.onggar.collector.service.CompetitiveRatingCalculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled("ADIK NE SDELAL")
class CompetitiveRatingCalculatorTest {

    @Autowired
    private CompetitiveRatingCalculator competitiveRatingCalculator;

    @Test
    void calculateNewRank() {
        assertEquals(10100, competitiveRatingCalculator.calculateNewRank(10_000,  1, LobbyType.COMMON));
        assertEquals(10070, competitiveRatingCalculator.calculateNewRank(10_000,  2, LobbyType.COMMON));
        assertEquals(10025, competitiveRatingCalculator.calculateNewRank(10_000,  3, LobbyType.COMMON));
        assertEquals(10000, competitiveRatingCalculator.calculateNewRank(10_000,  4, LobbyType.COMMON));
        assertEquals(9975, competitiveRatingCalculator.calculateNewRank(10_000, 5, LobbyType.COMMON));
        assertEquals(9950, competitiveRatingCalculator.calculateNewRank(10_000, 6, LobbyType.COMMON));
        assertEquals(9925, competitiveRatingCalculator.calculateNewRank(10_000, 7, LobbyType.COMMON));
        assertEquals(9900, competitiveRatingCalculator.calculateNewRank(10_000, 8, LobbyType.COMMON));
    }
}