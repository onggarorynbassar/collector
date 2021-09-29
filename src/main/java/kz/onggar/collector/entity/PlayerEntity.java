package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String steamId;

    private int simpleRating;

    private int competitiveRating;

    private int relativeRating;

    @OneToOne(mappedBy = "player")
    private PlayerPlaceEntity playerPlace;

    public UUID getId() {
        return id;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public int getSimpleRating() {
        return simpleRating;
    }

    public void setSimpleRating(int simpleMmr) {
        this.simpleRating = simpleMmr;
    }

    public int getCompetitiveRating() {
        return competitiveRating;
    }

    public void setCompetitiveRating(int competitiveMmr) {
        this.competitiveRating = competitiveMmr;
    }

    public int getRelativeRating() {
        return relativeRating;
    }

    public void setRelativeRating(int relativeMmr) {
        this.relativeRating = relativeMmr;
    }

    public PlayerPlaceEntity getPlayerPlace() {
        return playerPlace;
    }
}
