package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.WaveEntity;
import kz.onggar.collector.entity.WaveHistoryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.WaveHistoryRepository;
import kz.onggar.collector.repository.WaveRepository;
import kz.onggar.collector.service.npc.NpcPackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class WaveServiceImpl implements WaveService {
    private final WaveRepository waveRepository;
    private final NpcPackService npcPackService;
    private final WaveHistoryRepository waveHistoryRepository;

    public WaveServiceImpl(
            WaveRepository waveRepository,
            NpcPackService npcPackService,
            WaveHistoryRepository waveHistoryRepository
    ) {
        this.waveRepository = waveRepository;
        this.npcPackService = npcPackService;
        this.waveHistoryRepository = waveHistoryRepository;
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


    @Override
    @Transactional
    public WaveHistoryEntity createWaveHistory(MatchEntity matchEntity, UUID npcPackId, WaveEntity waveEntity) {
        return waveHistoryRepository.save(
                new WaveHistoryEntity()
                        .match(matchEntity)
                        .npcPack(npcPackService.findNpcPackById(npcPackId))
                        .wave(waveEntity)
        );
    }

    @Override
    @Transactional
    public WaveHistoryEntity findWaveHistoryById(UUID id) {
        return waveHistoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wave history entity with id=[%s] not found".formatted(id))
        );
    }
}