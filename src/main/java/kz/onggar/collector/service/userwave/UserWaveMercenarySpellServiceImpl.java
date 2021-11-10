package kz.onggar.collector.service.userwave;

import kz.onggar.collector.entity.UserWaveMercenarySpellEntity;
import kz.onggar.collector.repository.UserWaveMercenarySpellRepository;
import kz.onggar.collector.service.mercenary.MercenarySpellService;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserWaveMercenarySpellServiceImpl implements UserWaveMercenarySpellService {

    private final UserService userService;
    private final MercenarySpellService mercenarySpellService;
    private final WaveHistoryService waveHistoryService;
    private final UserWaveMercenarySpellRepository userWaveMercenarySpellRepository;

    public UserWaveMercenarySpellServiceImpl(UserService userService, MercenarySpellService mercenarySpellService, WaveHistoryService waveHistoryService, UserWaveMercenarySpellRepository userWaveMercenarySpellRepository) {
        this.userService = userService;
        this.mercenarySpellService = mercenarySpellService;
        this.waveHistoryService = waveHistoryService;
        this.userWaveMercenarySpellRepository = userWaveMercenarySpellRepository;
    }

    @Override
    @Transactional
    public void saveUserWaveMercenarySpell(UUID userId, UUID waveHistoryId, String mercenarySpellName) {
        var userWaveMercenarySpell = new UserWaveMercenarySpellEntity();
        userWaveMercenarySpell.user(userService.findUserById(userId));
        userWaveMercenarySpell.waveHistory(waveHistoryService.findWaveHistoryById(waveHistoryId));
        userWaveMercenarySpell.mercenarySpell(mercenarySpellService.getMercenarySpellByName(mercenarySpellName));

        userWaveMercenarySpellRepository.save(userWaveMercenarySpell);
    }
}
