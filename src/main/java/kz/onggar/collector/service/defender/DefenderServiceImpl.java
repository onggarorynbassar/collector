package kz.onggar.collector.service.defender;


import kz.onggar.collector.entity.DefenderEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.repository.DefenderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefenderServiceImpl implements DefenderService {

    private final DefenderRepository defenderRepository;

    public DefenderServiceImpl(DefenderRepository defenderRepository) {
        this.defenderRepository = defenderRepository;
    }

    @Override
    public void createDefender(String name) {
        defenderRepository.save(new DefenderEntity().name(name));
    }

    @Override
    public DefenderEntity findDefenderByName(String name) {
        return defenderRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Defender entity with name=[%s] not found".formatted(name))
        );
    }
}
