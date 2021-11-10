package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.WaveEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.WaveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class WaveServiceImpl implements WaveService {

    private final WaveRepository waveRepository;

    public WaveServiceImpl(WaveRepository waveRepository) {
        this.waveRepository = waveRepository;
    }

    @Override
    @Transactional
    public WaveEntity findWaveById(UUID id) {
        return waveRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wave entity with id=[%s] not found".formatted(id))
        );
    }

    @Override
    @Transactional
    public WaveEntity findWaveByRoundNumber(int roundNumber) {
        return waveRepository.findByRoundNumber(roundNumber).orElseThrow(
                () -> new ResourceNotFoundException("Wave entity with round number=[%s] not found".formatted(roundNumber))
        );
    }
}