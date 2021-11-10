package kz.onggar.collector.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "user_wave_ability_set")
@Accessors(fluent = true)
@Getter
@Setter
public class UserWaveAbilitySetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "wave_history_id", nullable = false)
    private WaveHistoryEntity waveHistory;

    @ManyToOne
    @JoinColumn(name = "npc_ability_set_id")
    private NpcAbilitySetEntity npcAbilitySet;
}
