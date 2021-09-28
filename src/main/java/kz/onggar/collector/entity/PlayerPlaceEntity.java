package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "match")
public class PlayerPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    private int place;
}
