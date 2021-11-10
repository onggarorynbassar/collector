package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.WaveHistoryEntity;

import java.util.UUID;

public interface WaveHistoryService {
    WaveHistoryEntity createWaveHistory(UUID matchId, UUID npcPackId, int waveNumber);
    WaveHistoryEntity findWaveHistoryById(UUID waveHistoryId);
}
