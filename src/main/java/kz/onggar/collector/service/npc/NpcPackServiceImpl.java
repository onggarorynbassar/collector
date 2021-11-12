package kz.onggar.collector.service.npc;

import kz.onggar.collector.entity.NpcPackEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.NpcPackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class NpcPackServiceImpl implements NpcPackService {
    private final NpcPackRepository npcPackRepository;
    private final NpcService npcService;

    public NpcPackServiceImpl(NpcPackRepository npcPackRepository, NpcService npcService) {
        this.npcPackRepository = npcPackRepository;
        this.npcService = npcService;
    }

    @Override
    @Transactional
    public NpcPackEntity findNpcPackById(UUID id) {
        return npcPackRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Npc pack entity with id=[%s] not found".formatted(id))
        );
    }

    @Override
    public NpcPackEntity findNpcPackByNpcName(String name) {
        var npcEntity = npcService.getByName(name);
        return npcPackRepository.findById(npcEntity.id()).orElseThrow(
                () -> new ResourceNotFoundException("Npc pack entity with id=[%s] not found".formatted(npcEntity.id()))
        );
    }
}
