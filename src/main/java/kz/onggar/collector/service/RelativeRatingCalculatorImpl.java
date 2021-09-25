package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyPlayerCount;
import kz.onggar.collector.configuration.RelativeRatingConfiguration;
import org.springframework.stereotype.Service;


@Service
public class RelativeRatingCalculatorImpl implements RelativeRatingCalculator {
    private final RelativeRatingConfiguration relativeRatingConfiguration;

    public RelativeRatingCalculatorImpl(RelativeRatingConfiguration relativeRatingConfiguration) {
        this.relativeRatingConfiguration = relativeRatingConfiguration;
    }

    public int calculateNewRank(int playerCurrentRating, int averageOtherPlayersRating, int place, LobbyPlayerCount playersCount) {
        double placeMultiplier = getPlaceMultiplier(place, playersCount);
        double maxRating = relativeRatingConfiguration.getMax();
        boolean isWinningPlace = isWinningPlace(place, playersCount);

        if (playersCount == LobbyPlayerCount.COMMON) {
            double topLimit, diffModifier;

            if (isWinningPlace) {
                topLimit = calculateTopLimit(playerCurrentRating, true);
                diffModifier = ((maxRating - (playerCurrentRating - averageOtherPlayersRating)) / maxRating);
            } else {
                topLimit = calculateTopLimit(playerCurrentRating, false);
                diffModifier = ((maxRating + (playerCurrentRating - averageOtherPlayersRating)) / maxRating);
            }

            var newRating = playerCurrentRating + (topLimit * diffModifier * placeMultiplier);
            return (int) Math.round(newRating);
        } else {
            throw new IllegalArgumentException("Unexpected lobby player count");
        }
    }

    private double getPlaceMultiplier(int place, LobbyPlayerCount playerCount) {
        if (playerCount == LobbyPlayerCount.COMMON) {
            return relativeRatingConfiguration.getScoreDistribution().get(LobbyPlayerCount.COMMON.name()).get(place);
        } else {
            throw new IllegalArgumentException("Unexpected place");
        }
    }

    private boolean isWinningPlace(int place, LobbyPlayerCount playerCount) {
        if (playerCount == LobbyPlayerCount.COMMON) {
            return place < 5;
        } else {
            throw new IllegalArgumentException("Unexpected place");
        }
    }

    private double calculateTopLimit(int currentRating, boolean isWinningPlace) {
        double maxRating = relativeRatingConfiguration.getMax();

        if (isWinningPlace) {
            return (1 - (currentRating / maxRating));
        } else {
            return 1;
        }
    }
}
