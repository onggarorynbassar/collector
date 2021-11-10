package kz.onggar.collector.service.npcpack;

import kz.onggar.collector.entity.NpcPackEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.NpcPackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class NpcPackServiceImpl implements NpcPackService {

    private final NpcPackRepository npcPackRepository;

    public NpcPackServiceImpl(NpcPackRepository npcPackRepository) {
        this.npcPackRepository = npcPackRepository;
    }

    @Override
    @Transactional
    public NpcPackEntity findNpcPackById(UUID id) {
        return npcPackRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Npc pack entity with id=[%s] not found".formatted(id))
        );
    }
}
