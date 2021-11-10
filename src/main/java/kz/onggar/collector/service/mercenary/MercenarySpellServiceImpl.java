package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenarySpellEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.MercenarySpellRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MercenarySpellServiceImpl implements MercenarySpellService {

    private final MercenarySpellRepository mercenarySpellRepository;

    public MercenarySpellServiceImpl(MercenarySpellRepository mercenarySpellRepository) {
        this.mercenarySpellRepository = mercenarySpellRepository;
    }

    @Override
    @Transactional
    public MercenarySpellEntity getMercenarySpellByName(String name) {
        return mercenarySpellRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Mercenary spell entity with name=[%s] not found".formatted(name)));
    }
}
