package kz.onggar.collector.service.defender;


import kz.onggar.collector.entity.DefenderPositionEntity;
import kz.onggar.collector.openapi.dto.Defender;
import kz.onggar.collector.repository.DefenderPositionRepository;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DefenderPositionServiceImpl implements DefenderPositionService {

    private final DefenderPositionRepository defenderPositionRepository;
    private final UserService userService;
    private final WaveService waveService;
    private final DefenderService defenderService;

    public DefenderPositionServiceImpl(DefenderPositionRepository defenderPositionRepository, UserService userService, WaveService waveService, DefenderService defenderService) {
        this.defenderPositionRepository = defenderPositionRepository;
        this.userService = userService;
        this.waveService = waveService;
        this.defenderService = defenderService;
    }

    @Override
    @Transactional
    public void saveDefenderPosition(Defender defender, UUID userId, int waveNumber) {
        var defenderPosition = new DefenderPositionEntity();

        defenderPosition.defender(defenderService.findDefenderByName(defender.getName()));
        defenderPosition.user(userService.findUserById(userId));
        defenderPosition.wave(waveService.findWaveByRoundNumber(waveNumber));
        defenderPosition.positionX(defender.getPositionX());
        defenderPosition.positionY(defender.getPositionY());

        defenderPositionRepository.save(defenderPosition);
    }
}
