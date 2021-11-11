package kz.onggar.collector.service.defender;


import kz.onggar.collector.entity.DefenderEntity;
import kz.onggar.collector.entity.DefenderPositionEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.openapi.dto.Defender;
import kz.onggar.collector.repository.DefenderPositionRepository;
import kz.onggar.collector.repository.DefenderRepository;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class DefenderServiceImpl implements DefenderService {
    private final DefenderRepository defenderRepository;
    private final DefenderPositionRepository defenderPositionRepository;
    private final UserService userService;
    private final WaveService waveService;

    public DefenderServiceImpl(
            DefenderRepository defenderRepository,
            DefenderPositionRepository defenderPositionRepository,
            UserService userService,
            WaveService waveService
    ) {
        this.defenderRepository = defenderRepository;
        this.defenderPositionRepository = defenderPositionRepository;
        this.userService = userService;
        this.waveService = waveService;
    }

    @Override
    public void createDefender(String name) {
        defenderRepository.save(new DefenderEntity().name(name));
    }

    @Override
    @Transactional
    public DefenderEntity findDefenderByName(String name) {
        return defenderRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Defender entity with name=[%s] not found".formatted(name))
        );
    }

    @Override
    @Transactional
    public void saveDefenderPosition(Defender defender, UUID userId, int waveNumber) {
        var defenderPosition = new DefenderPositionEntity();

        defenderPosition.defender(findDefenderByName(defender.getName()));
        defenderPosition.user(userService.findUserEntityById(userId));
        defenderPosition.wave(waveService.findWaveByRoundNumber(waveNumber));
        defenderPosition.positionX(defender.getPositionX());
        defenderPosition.positionY(defender.getPositionY());

        defenderPositionRepository.save(defenderPosition);
    }
}
