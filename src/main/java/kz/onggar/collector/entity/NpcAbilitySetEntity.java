package kz.onggar.collector.entity;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "npc_ability_set")
@Accessors(fluent = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NpcAbilitySetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "npc_id", nullable = false)
    private NpcEntity npc;

    private int option;
}
