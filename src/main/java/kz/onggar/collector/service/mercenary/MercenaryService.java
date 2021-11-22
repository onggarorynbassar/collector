package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenaryEntity;

import java.util.UUID;

public interface MercenaryService {
    MercenaryEntity getMercenaryByName(String name);
    void saveWaveMercenary(UUID userId, UUID waveHistoryId, String mercenaryNpcName, int count);
    MercenaryEntity createMercenary(String name);
}
