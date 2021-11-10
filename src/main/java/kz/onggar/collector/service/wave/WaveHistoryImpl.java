package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.WaveHistoryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.WaveHistoryRepository;
import kz.onggar.collector.service.match.MatchServiceImpl;
import kz.onggar.collector.service.npcpack.NpcPackServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class WaveHistoryImpl implements WaveHistoryService {

    private final WaveHistoryRepository waveHistoryRepository;
    private final MatchServiceImpl matchService;
    private final NpcPackServiceImpl npcPackService;
    private final WaveServiceImpl waveService;

    public WaveHistoryImpl(WaveHistoryRepository waveHistoryRepository, MatchServiceImpl matchService, NpcPackServiceImpl npcPackService, WaveServiceImpl waveService) {
        this.waveHistoryRepository = waveHistoryRepository;
        this.matchService = matchService;
        this.npcPackService = npcPackService;
        this.waveService = waveService;
    }


    @Override
    @Transactional
    public WaveHistoryEntity createWaveHistory(UUID matchId, UUID npcPackId, int waveNumber) {
        return waveHistoryRepository.save(
                new WaveHistoryEntity()
                        .match(matchService.getMatchEntity(matchId))
                        .npcPack(npcPackService.findNpcPackById(npcPackId))
                        .wave(waveService.findWaveByRoundNumber(waveNumber))
        );
    }

    @Override
    @Transactional
    public WaveHistoryEntity findWaveHistoryById(UUID waveHistoryId) {
        return waveHistoryRepository.findById(waveHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("Wave history entity with id=[%s] not found".formatted(waveHistoryId))
        );
    }
}
