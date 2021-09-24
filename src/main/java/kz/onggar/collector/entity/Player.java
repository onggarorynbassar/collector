package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "steam_id", nullable = false)
    private String steamId;
    @Column
    private int simpleMmr;
    @Column
    private int competitiveMmr;
    @Column
    private int relativeMmr;
}
