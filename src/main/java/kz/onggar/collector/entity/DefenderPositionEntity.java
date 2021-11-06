package kz.onggar.collector.entity;


import kz.onggar.collector.openapi.dto.Defender;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "defender_position")
@Accessors(fluent = true)
@Getter
@Setter
public class DefenderPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "defender_id", nullable = false)
    private DefenderEntity defender;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "wave_id", nullable = false)
    private WaveEntity wave;

    private int positionX = 0;

    private int positionY = 0;
}
