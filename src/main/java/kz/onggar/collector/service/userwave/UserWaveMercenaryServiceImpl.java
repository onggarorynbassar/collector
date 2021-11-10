package kz.onggar.collector.service.userwave;


import kz.onggar.collector.entity.UserWaveMercenaryEntity;
import kz.onggar.collector.repository.UserWaveMercenaryRepository;
import kz.onggar.collector.service.mercenary.MercenaryService;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserWaveMercenaryServiceImpl implements UserWaveMercenaryService {

    private final UserWaveMercenaryRepository userWaveMercenaryRepository;
    private final UserService userService;
    private final WaveHistoryService waveHistory;
    private final MercenaryService mercenaryService;

    public UserWaveMercenaryServiceImpl(UserWaveMercenaryRepository userWaveMercenaryRepository, UserService userService, WaveHistoryService waveHistory, MercenaryService mercenaryService) {
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
