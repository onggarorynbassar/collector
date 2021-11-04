package kz.onggar.collector.service.rating;

import kz.onggar.collector.component.LobbyType;
import kz.onggar.collector.configuration.RelativeRatingConfiguration;
import kz.onggar.collector.exception.UnexpectedExecutionStateException;
import org.springframework.stereotype.Service;


@Service
public class RelativeRatingCalculatorImpl implements RelativeRatingCalculator {
    private final RelativeRatingConfiguration relativeRatingConfiguration;

    public RelativeRatingCalculatorImpl(RelativeRatingConfiguration relativeRatingConfiguration) {
        this.relativeRatingConfiguration = relativeRatingConfiguration;
    }

    public int calculateNewRank(int UserCurrentRating, int averageOtherUsersRating, int place, LobbyType lobbyType) {
        double placeMultiplier = getPlaceMultiplier(place, lobbyType);
        double maxRating = relativeRatingConfiguration.getMax();
        boolean isWinningPlace = isWinningPlace(place, lobbyType);

        if (lobbyType == LobbyType.COMMON) {
            double topLimit, diffModifier;

            if (isWinningPlace) {
                topLimit = calculateTopLimit(UserCurrentRating, true);
                diffModifier = ((maxRating - (UserCurrentRating - averageOtherUsersRating)) / maxRating);
            } else {
                topLimit = calculateTopLimit(UserCurrentRating, false);
                diffModifier = ((maxRating + (UserCurrentRating - averageOtherUsersRating)) / maxRating);
            }

            var newRating = UserCurrentRating + (topLimit * diffModifier * placeMultiplier);
            return (int) Math.round(newRating);
        } else {
            throw new UnexpectedExecutionStateException("Unexpected lobby type. type:[%s]".formatted(lobbyType));
        }
    }

    private double getPlaceMultiplier(int place, LobbyType lobbyType) {
        if (lobbyType == LobbyType.COMMON) {
            return relativeRatingConfiguration.getScoreDistribution().get(LobbyType.COMMON.name()).get(place);
        } else {
            throw new UnexpectedExecutionStateException("Unexpected place. place:[%s] should be around [1-8]".formatted(place));
        }
    }

    private boolean isWinningPlace(int place, LobbyType lobbyType) {
        if (lobbyType == LobbyType.COMMON) {
            return place < 5;
        } else {
            throw new UnexpectedExecutionStateException("Unexpected place. place:[%s] should be around [1-8]".formatted(place));
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
