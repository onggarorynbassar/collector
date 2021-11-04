package kz.onggar.collector;

import kz.onggar.collector.component.LobbyType;
import kz.onggar.collector.service.rating.RelativeRatingCalculator;
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
        assertEquals(10089, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 1, LobbyType.COMMON));
        assertEquals(10062, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 2, LobbyType.COMMON));
        assertEquals(10036, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 3, LobbyType.COMMON));
        assertEquals(10018, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 4, LobbyType.COMMON));
        assertEquals(9987, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 5, LobbyType.COMMON));
        assertEquals(9973, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 6, LobbyType.COMMON));
        assertEquals(9953, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 7, LobbyType.COMMON));
        assertEquals(9933, relativeRatingCalculator.calculateNewRank(10_000, 20_000, 8, LobbyType.COMMON));

        //TODO добавить еще тесты которые проверяют когда UserCurrentRating = 0, или когда avgOtherUsersRating 30_000
    }
}