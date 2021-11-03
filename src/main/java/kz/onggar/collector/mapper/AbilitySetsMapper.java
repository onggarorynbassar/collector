package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.openapi.dto.NpcAbilitySet;

import java.util.List;
import java.util.stream.Collectors;

public class AbilitySetsMapper {
    public static List<NpcAbilitySet> toDto(List<NpcAbilitySetEntity> npcAbilitySets) {

        return npcAbilitySets
                .stream()
                .collect(
                        Collectors.groupingBy(
                                abilitySetEntity -> abilitySetEntity.npcEntity().name()
                        )
                ).entrySet().stream().map(
                        it -> new NpcAbilitySet()
                                .npcName(it.getKey())
                                .options(
                                        it.getValue().stream()
                                                .map(NpcAbilitySetEntity::option)
                                                .collect(Collectors.toList())
                                )
                ).collect(Collectors.toList());
    }
}
