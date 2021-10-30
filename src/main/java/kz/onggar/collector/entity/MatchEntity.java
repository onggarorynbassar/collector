package kz.onggar.collector.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "match")
@Accessors(fluent = true)
@Getter
@Setter
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany
    @JoinTable(
            schema = "collector",
            name = "match_history",
            joinColumns = {@JoinColumn(name = "match_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_place_id")})
    private List<PlayerPlaceEntity> playerPlaces = new ArrayList<>();
}