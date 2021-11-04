package kz.onggar.collector.service.npc;

import kz.onggar.collector.entity.NpcAbilitySetEntity;

public interface NpcAbilitySetService {
    NpcAbilitySetEntity createNpcAbilitySet(String npcName, int option);
}
