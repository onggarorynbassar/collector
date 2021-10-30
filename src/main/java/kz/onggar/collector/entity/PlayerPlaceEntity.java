package kz.onggar.collector.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "player_place")
@Accessors(fluent = true)
@Getter
@Setter
public class PlayerPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private PlayerEntity player;

    private int place;
}
