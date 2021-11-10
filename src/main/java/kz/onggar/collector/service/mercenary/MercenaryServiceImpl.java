package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenaryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.MercenaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MercenaryServiceImpl implements MercenaryService {

    private final MercenaryRepository mercenaryNpcRepository;

    public MercenaryServiceImpl(MercenaryRepository mercenaryNpcRepository) {
        this.mercenaryNpcRepository = mercenaryNpcRepository;
    }

    @Override
    @Transactional
    public MercenaryEntity getMercenaryByName(String name) {
        return mercenaryNpcRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Mercenary entity with name=[%s] not found".formatted(name)));
    }
}