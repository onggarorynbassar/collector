package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenarySpellEntity;

import java.util.UUID;

public interface MercenarySpellService {
    MercenarySpellEntity getMercenarySpellByName(String name);
    void saveWaveMercenarySpell(UUID userId, UUID waveHistoryId, String mercenarySpellName);
}
