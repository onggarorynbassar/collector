package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyPlayerCount;
import org.springframework.stereotype.Service;

@Service
public class RelativeRatingCalculatorImpl implements RelativeRatingCalculator {
    public int calculateNewRank(int playerCurrentRating, int averageOtherPlayersRating, int place, LobbyPlayerCount playersCount) {
        return 0;
    }
}
