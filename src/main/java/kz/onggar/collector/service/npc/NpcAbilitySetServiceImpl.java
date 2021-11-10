package kz.onggar.collector.service.npc;


import kz.onggar.collector.entity.NpcAbilitySetEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.NpcAbilitySetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    @Transactional
    public NpcAbilitySetEntity findNpcAbilitySetById(UUID id) {
        return npcAbilitySetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Npc ability set with id=[%s] not found".formatted(id))
        );
    }
}
