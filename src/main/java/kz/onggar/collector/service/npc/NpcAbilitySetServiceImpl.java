package kz.onggar.collector.service.npc;


import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.repository.NpcAbilitySetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NpcAbilitySetServiceImpl implements NpcAbilitySetService {
    private final NpcAbilitySetRepository npcAbilitySetRepository;
    private final NpcService npcService;

    public NpcAbilitySetServiceImpl(NpcAbilitySetRepository npcAbilitySetRepository, NpcService npcService) {
        this.npcAbilitySetRepository = npcAbilitySetRepository;
        this.npcService = npcService;
    }

    @Override
    @Transactional
    public NpcAbilitySetEntity createNpcAbilitySet(String npcName, int option) {
        var npc = npcService.getByName(npcName);

        return npcAbilitySetRepository.save(
                new NpcAbilitySetEntity()
                        .npcEntity(npc)
                        .option(option)
        );
    }
}
