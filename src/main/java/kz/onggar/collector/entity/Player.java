package kz.onggar.collector.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "player", schema = "collector")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String steamId;

    private int simpleMmr;

    private int competitiveMmr;

    private int relativeMmr;
}
