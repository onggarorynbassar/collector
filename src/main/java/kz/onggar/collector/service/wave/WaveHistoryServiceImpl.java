package kz.onggar.collector.service.wave;

import kz.onggar.collector.entity.WaveHistoryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.WaveHistoryRepository;
import kz.onggar.collector.service.match.MatchService;
import kz.onggar.collector.service.npcpack.NpcPackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class WaveHistoryServiceImpl implements WaveHistoryService {

    private final WaveHistoryRepository waveHistoryRepository;
    private final MatchService matchService;
    private final NpcPackService npcPackService;
    private final WaveService waveService;

    public WaveHistoryServiceImpl(WaveHistoryRepository waveHistoryRepository, MatchService matchService, NpcPackService npcPackService, WaveService waveService) {
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
