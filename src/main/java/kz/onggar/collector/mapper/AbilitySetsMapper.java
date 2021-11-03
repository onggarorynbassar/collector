package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.openapi.dto.NpcAbilitySet;

import java.util.List;
import java.util.stream.Collectors;

public class AbilitySetsMapper {
    public static List<NpcAbilitySet> toDto(List<NpcAbilitySetEntity> npcAbilitySets) {

        var a = npcAbilitySets
                .stream()
                .collect(
                        Collectors
                                .groupingBy(abilitySetEntity -> abilitySetEntity
                                        .npcEntity()
                                        .name()));

        return null;
    }
}
