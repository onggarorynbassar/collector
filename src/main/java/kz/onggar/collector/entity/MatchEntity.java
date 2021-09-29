package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "match_history",
            joinColumns = {@JoinColumn(name = "match_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_place_id")})
    private List<PlayerPlaceEntity> playerPlaces = new ArrayList<>();

    public List<PlayerPlaceEntity> getPlayerPlaces() {
        return playerPlaces;
    }

    public void setPlayerPlaces(List<PlayerPlaceEntity> playerPlaces) {
        this.playerPlaces = playerPlaces;
    }
}