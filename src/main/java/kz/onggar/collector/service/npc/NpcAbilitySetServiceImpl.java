package kz.onggar.collector.service.npc;


import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.entity.WaveAbilitySetEntity;
import kz.onggar.collector.entity.WaveHistoryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.NpcAbilitySetRepository;
import kz.onggar.collector.repository.WaveAbilitySetRepository;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class NpcAbilitySetServiceImpl implements NpcAbilitySetService {
    private final NpcAbilitySetRepository npcAbilitySetRepository;
    private final NpcService npcService;
    private final UserService userService;
    private final WaveService waveService;
    private final WaveAbilitySetRepository waveAbilitySetRepository;

    public NpcAbilitySetServiceImpl(
            NpcAbilitySetRepository npcAbilitySetRepository,
            NpcService npcService,
            UserService userService,
            WaveService waveService,
            WaveAbilitySetRepository waveAbilitySetRepository
    ) {
        this.npcAbilitySetRepository = npcAbilitySetRepository;
        this.npcService = npcService;
        this.userService = userService;
        this.waveService = waveService;
        this.waveAbilitySetRepository = waveAbilitySetRepository;
    }

    @Override
    @Transactional
    public NpcAbilitySetEntity createNpcAbilitySet(String npcName, int option) {
        var npc = npcService.getByName(npcName);

        return npcAbilitySetRepository.save(
                new NpcAbilitySetEntity()
                        .npc(npc)
                        .option(option)
        );
    }

    @Override
    @Transactional
    public NpcAbilitySetEntity findNpcAbilitySetById(UUID id) {
        return npcAbilitySetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Npc ability set with id=[%s] not found".formatted(id))
        );
    }

    @Override
    @Transactional
    public NpcAbilitySetEntity findByNpcIdAndOption(UUID npcId, int option) {
        return npcAbilitySetRepository.findByNpc_IdAndOption(npcId, option).orElseThrow(
                () -> new ResourceNotFoundException("Npc ability set with npc_id=[%s] and option=[%s] not found".formatted(npcId, option)));


    }

    @Override
    @Transactional
    public void saveWaveAbilitySet(UUID userId, UUID waveHistoryId, String npcName, int npcAbilitySetOption) {
        var userWaveAbilitySet = new WaveAbilitySetEntity();

        userWaveAbilitySet.user(userService.findUserEntityById(userId));
        userWaveAbilitySet.waveHistory(waveService.findWaveHistoryById(waveHistoryId));
        userWaveAbilitySet.npcAbilitySet(
                findNpcAbilitySetById(
                        findByNpcIdAndOption(
                                npcService.getByName(npcName).id(),
                                npcAbilitySetOption
                        ).id()
                )
        );

        waveAbilitySetRepository.save(userWaveAbilitySet);
    }
}
