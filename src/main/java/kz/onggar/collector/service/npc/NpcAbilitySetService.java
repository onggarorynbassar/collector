package kz.onggar.collector.service.npc;

import kz.onggar.collector.entity.NpcAbilitySetEntity;

import java.util.Optional;
import java.util.UUID;

public interface NpcAbilitySetService {
    NpcAbilitySetEntity createNpcAbilitySet(String npcName, int option);
    NpcAbilitySetEntity findNpcAbilitySetById(UUID id);
    void saveWaveAbilitySet(UUID userId, UUID waveHistoryId, UUID npcAbilitySetId);
}
