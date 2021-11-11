package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenaryEntity;
import kz.onggar.collector.entity.WaveMercenaryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.MercenaryRepository;
import kz.onggar.collector.repository.WaveMercenaryRepository;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MercenaryServiceImpl implements MercenaryService {
    private final MercenaryRepository mercenaryNpcRepository;
    private final UserService userService;
    private final WaveService waveService;
    private final WaveMercenaryRepository waveMercenaryRepository;

    public MercenaryServiceImpl(
            MercenaryRepository mercenaryNpcRepository,
            UserService userService,
            WaveService waveService,
            WaveMercenaryRepository waveMercenaryRepository
    ) {
        this.mercenaryNpcRepository = mercenaryNpcRepository;
        this.userService = userService;
        this.waveService = waveService;
        this.waveMercenaryRepository = waveMercenaryRepository;
    }

    @Override
    @Transactional
    public MercenaryEntity getMercenaryByName(String name) {
        return mercenaryNpcRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Mercenary entity with name=[%s] not found".formatted(name)));
    }

    @Override
    @Transactional
    public void saveWaveMercenary(UUID userId, UUID waveHistoryId, String mercenaryNpcName, int count) {
        var userWaveMercenary = new WaveMercenaryEntity();

        userWaveMercenary.user(userService.findUserEntityById(userId));
        userWaveMercenary.waveHistory(waveService.findWaveHistoryById(waveHistoryId));
        userWaveMercenary.mercenary(getMercenaryByName(mercenaryNpcName));
        userWaveMercenary.count(count);

        waveMercenaryRepository.save(userWaveMercenary);
    }
}