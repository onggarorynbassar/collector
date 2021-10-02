package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "player_place")
public class PlayerPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private PlayerEntity player;

    private int place;

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
