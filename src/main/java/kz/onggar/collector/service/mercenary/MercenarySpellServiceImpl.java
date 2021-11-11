package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenarySpellEntity;
import kz.onggar.collector.entity.WaveMercenarySpellEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.MercenarySpellRepository;
import kz.onggar.collector.repository.WaveMercenarySpellRepository;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MercenarySpellServiceImpl implements MercenarySpellService {
    private final MercenarySpellRepository mercenarySpellRepository;
    private final WaveMercenarySpellRepository waveMercenarySpellRepository;
    private final WaveService waveService;
    private final UserService userService;

    public MercenarySpellServiceImpl(
            MercenarySpellRepository mercenarySpellRepository,
            WaveMercenarySpellRepository waveMercenarySpellRepository,
            WaveService waveService,
            UserService userService
    ) {
        this.mercenarySpellRepository = mercenarySpellRepository;
        this.waveMercenarySpellRepository = waveMercenarySpellRepository;
        this.waveService = waveService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public MercenarySpellEntity getMercenarySpellByName(String name) {
        return mercenarySpellRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Mercenary spell entity with name=[%s] not found".formatted(name)));
    }

    @Override
    @Transactional
    public void saveWaveMercenarySpell(UUID userId, UUID waveHistoryId, String mercenarySpellName) {
        var userWaveMercenarySpell = new WaveMercenarySpellEntity();
        userWaveMercenarySpell.user(userService.findUserEntityById(userId));
        userWaveMercenarySpell.waveHistory(waveService.findWaveHistoryById(waveHistoryId));
        userWaveMercenarySpell.mercenarySpell(getMercenarySpellByName(mercenarySpellName));

        waveMercenarySpellRepository.save(userWaveMercenarySpell);
    }
}
