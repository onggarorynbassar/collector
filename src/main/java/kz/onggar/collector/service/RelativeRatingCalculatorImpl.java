package kz.onggar.collector.service;

import kz.onggar.collector.component.LobbyPlayerCount;
import org.springframework.stereotype.Service;


@Service
public class RelativeRatingCalculatorImpl implements RelativeRatingCalculator {

    private double calculatePlaceMultiplier(int place) {
        int calculatedPlaceMultiplier;
        switch (place) {
            case 1 -> calculatedPlaceMultiplier = 100;
            case 2 -> calculatedPlaceMultiplier = 70;
            case 3 -> calculatedPlaceMultiplier = 40;
            case 4 -> calculatedPlaceMultiplier = 20;
            case 5 -> calculatedPlaceMultiplier = -20;
            case 6 -> calculatedPlaceMultiplier = -40;
            case 7 -> calculatedPlaceMultiplier = -70;
            case 8 -> calculatedPlaceMultiplier = -100;
            default -> throw new IllegalStateException("Unexpected value: " + place);
        }

        return calculatedPlaceMultiplier * 1.0;
    }

    public int calculateNewRank(int playerCurrentRating, int averageOtherPlayersRating, int place, LobbyPlayerCount playersCount) {

        double doubledPlayerCurrentRating = playerCurrentRating * 1.0;
        double doubleAverageOtherPlayersRating = averageOtherPlayersRating * 1.0;
        double placeMultiplier = calculatePlaceMultiplier(place);
        double result = 0;


        if (Math.signum(placeMultiplier) == 1.0) {
            result = (1 - (doubledPlayerCurrentRating / 30000)) * ((30000 - (doubledPlayerCurrentRating - averageOtherPlayersRating)) / 30000) * placeMultiplier;
        } else if (Math.signum(placeMultiplier) == -1.0) {
            result = (1 - (doubledPlayerCurrentRating / 30000)) * ((30000 + (doubledPlayerCurrentRating - averageOtherPlayersRating)) / 30000) * placeMultiplier;
        } else {
            return (int) result;
        }
        return (int) Math.round(result) + playerCurrentRating;
    }
}
