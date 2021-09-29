package kz.onggar.collector.dto;

import java.util.Map;

public class MatchResult {

    Map<Integer, Player> playerPlaces;

    public Map<Integer, Player> getPlayerPlaces() {
        return playerPlaces;
    }

    public void setPlayerPlaces(Map<Integer, Player> playerPlaces) {
        this.playerPlaces = playerPlaces;
    }
}
