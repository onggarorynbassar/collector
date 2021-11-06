package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.entity.WaveEntity;

import java.util.UUID;

public interface WaveService {
    WaveEntity findWaveById(UUID id);

    WaveEntity findWaveByRoundNumber(int roundNumber);
}
