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

    private int simpleMmr;

    private int competitiveMmr;

    private int relativeMmr;
}
