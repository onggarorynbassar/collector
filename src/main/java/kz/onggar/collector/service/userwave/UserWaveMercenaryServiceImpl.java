package kz.onggar.collector.service.userwave;


import kz.onggar.collector.entity.UserWaveMercenaryEntity;
import kz.onggar.collector.repository.UserWaveMercenaryRepository;
import kz.onggar.collector.service.mercenary.MercenaryServiceImpl;
import kz.onggar.collector.service.user.UserServiceImpl;
import kz.onggar.collector.service.wave.WaveHistoryImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class UserWaveMercenaryServiceImpl implements UserWaveMercenaryService {

    private final UserWaveMercenaryRepository userWaveMercenaryRepository;
    private final UserServiceImpl userService;
    private final WaveHistoryImpl waveHistory;
    private final MercenaryServiceImpl mercenaryService;

    public UserWaveMercenaryServiceImpl(UserWaveMercenaryRepository userWaveMercenaryRepository, UserServiceImpl userService, WaveHistoryImpl waveHistory, MercenaryServiceImpl mercenaryService) {
        this.userWaveMercenaryRepository = userWaveMercenaryRepository;
        this.userService = userService;
        this.waveHistory = waveHistory;
        this.mercenaryService = mercenaryService;
    }

    @Override
    @Transactional
    public void saveUserWaveMercenary(UUID userId, UUID waveHistoryId, String mercenaryNpcName, int count) {
        var userWaveMercenary = new UserWaveMercenaryEntity();
        userWaveMercenary.user(userService.findUserById(userId));
        userWaveMercenary.waveHistory(waveHistory.findWaveHistoryById(waveHistoryId));
        userWaveMercenary.mercenary(mercenaryService.getMercenaryByName(mercenaryNpcName));
        userWaveMercenary.count(count);

        userWaveMercenaryRepository.save(userWaveMercenary);
    }
}
