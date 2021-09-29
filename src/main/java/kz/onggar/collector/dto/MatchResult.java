package kz.onggar.collector.dto;

import java.util.List;

public class MatchResult {

    List<PlayerWithPlace> playersWithPlaces;

    public List<PlayerWithPlace> getPlayersWithPlaces() {
        return playersWithPlaces;
    }

    public void setPlayersWithPlaces(List<PlayerWithPlace> playersWithPlaces) {
        this.playersWithPlaces = playersWithPlaces;
    }
}
