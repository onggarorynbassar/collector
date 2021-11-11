package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.entity.WaveEntity;
import kz.onggar.collector.entity.WaveHistoryEntity;

import java.util.UUID;

public interface WaveService {
    WaveEntity findWaveById(UUID id);
    WaveEntity findWaveByRoundNumber(int roundNumber);
    WaveHistoryEntity createWaveHistory(MatchEntity matchEntity, UUID npcPackId, WaveEntity waveEntity);
    WaveHistoryEntity findWaveHistoryById(UUID waveHistoryId);
}
