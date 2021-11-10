package kz.onggar.collector.service.userwave;

import java.util.UUID;

public interface UserWaveAbilitySetService {
    void saveUserWaveAbilitySet(UUID userId, UUID waveHistoryId, UUID npcAbilitySetId);
}
