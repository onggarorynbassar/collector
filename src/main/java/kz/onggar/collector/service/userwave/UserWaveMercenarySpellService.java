package kz.onggar.collector.service.userwave;

import java.util.UUID;

public interface UserWaveMercenarySpellService {
    void saveUserWaveMercenarySpell(UUID userId, UUID waveHistoryId, String mercenarySpellName);

}
