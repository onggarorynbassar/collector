package kz.onggar.collector.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "collector", name = "user")
@Accessors(fluent = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String steamId;

    private int simpleRating;

    private int competitiveRating;

    private int relativeRating;

    @OneToMany(mappedBy = "userEntity")
    private List<UserSettingEntity> settings = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "user_npc_ability_override",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "npc_ability_set_id")}
    )
    private List<NpcAbilitySetEntity> npcAbilitySets;
}