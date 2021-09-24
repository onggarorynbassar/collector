package kz.onggar.collector.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "steam_id", nullable = false)
    private String steam_id;
    @Column(name = "simple_mmr", nullable = false)
    private int simpleMmr;
    @Column(name = "competitive_mmr", nullable = false)
    private int competitiveMmr;
    @Column(name = "relative_mmr", nullable = false)
    private int relativeMmr;
}
