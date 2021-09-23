package kz.onggar.collector.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Player {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "steam_id", updatable = true, nullable = false)
    private String steam_id;
    @Column(name = "simple_mmr", updatable = true, nullable = false)
    private int simple_mmr;
    @Column(name = "competitive_mmr", updatable = true, nullable = false)
    private int competitive_mmr;
    @Column(name = "relative_mmr", updatable = true, nullable = false)
    private int relative_mmr;
}
