package kz.onggar.collector.service.userwave;

import kz.onggar.collector.entity.UserWaveAbilitySetEntity;
import kz.onggar.collector.repository.UserWaveAbilitySetRepository;
import kz.onggar.collector.service.npc.NpcAbilitySetService;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveHistoryService;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class UserWaveAbilitySetServiceImpl implements UserWaveAbilitySetService {

    private final UserWaveAbilitySetRepository userWaveAbilitySetRepository;
    private final UserService userService;
    private final NpcAbilitySetService npcAbilitySetService;
    private final WaveHistoryService waveHistoryService;

    public UserWaveAbilitySetServiceImpl(UserWaveAbilitySetRepository userWaveAbilitySetRepository, UserService userService, NpcAbilitySetService npcAbilitySetService, WaveHistoryService waveHistoryService) {
        this.userWaveAbilitySetRepository = userWaveAbilitySetRepository;
        this.userService = userService;
        this.npcAbilitySetService = npcAbilitySetService;
        this.waveHistoryService = waveHistoryService;
    }

    @Override
    @Transactional
    public void saveUserWaveAbilitySet(UUID userId, UUID waveHistoryId, UUID npcAbilitySetId) {
        var userWaveAbilitySet = new UserWaveAbilitySetEntity();

        userWaveAbilitySet.user(userService.findUserById(userId));
        userWaveAbilitySet.waveHistory(waveHistoryService.findWaveHistoryById(waveHistoryId));
        userWaveAbilitySet.npcAbilitySet(npcAbilitySetService.findNpcAbilitySetById(npcAbilitySetId));

        userWaveAbilitySetRepository.save(userWaveAbilitySet);
    }
}
