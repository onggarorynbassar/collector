package kz.onggar.collector.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "player")
@Accessors(fluent = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String steamId;

    private int simpleRating;

    private int competitiveRating;

    private int relativeRating;
}
