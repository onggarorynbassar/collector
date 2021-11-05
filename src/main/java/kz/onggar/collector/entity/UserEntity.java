package kz.onggar.collector.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserSettingEntity> settings = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            schema = "collector",
            name = "user_npc_ability_override",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "npc_ability_set_id")}
    )
    private List<NpcAbilitySetEntity> npcAbilitySets = new ArrayList<>();


}
