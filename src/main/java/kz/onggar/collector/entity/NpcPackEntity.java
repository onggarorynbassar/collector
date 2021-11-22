package kz.onggar.collector.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "npc_pack")
@Accessors(fluent = true)
@Getter
@Setter
public class NpcPackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne()
    @JoinColumn(name = "npc_id", referencedColumnName = "id")
    private NpcEntity npc;

    private int count;
}
