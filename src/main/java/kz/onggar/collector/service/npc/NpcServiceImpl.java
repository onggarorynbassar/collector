package kz.onggar.collector.service.npc;


import kz.onggar.collector.entity.NpcEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.NpcRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NpcServiceImpl implements NpcService {
    private final NpcRepository npcRepository;

    public NpcServiceImpl(NpcRepository npcRepository) {
        this.npcRepository = npcRepository;
    }

    @Override
    @Transactional
    public NpcEntity createNpc(String name) {
        return npcRepository.save(new NpcEntity().name(name));
    }

    @Override
    @Transactional
    public NpcEntity getByName(String name) {
        return npcRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Npc with name=[%s] not found".formatted(name))
        );
    }
}
