package kz.onggar.collector.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "wave_history")
@Accessors(fluent = true)
@Getter
@Setter
public class WaveHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "match_id", nullable = false)
    MatchEntity match;

    @ManyToOne()
    @JoinColumn(name = "npc_pack_id", nullable = false)
    NpcPackEntity npcPack;

    @ManyToOne()
    @JoinColumn(name = "wave_id", nullable = false)
    WaveEntity wave;
}
