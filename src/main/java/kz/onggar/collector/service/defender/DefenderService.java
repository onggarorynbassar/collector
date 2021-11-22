package kz.onggar.collector.service.defender;

import kz.onggar.collector.entity.DefenderEntity;
import kz.onggar.collector.openapi.dto.Defender;

import java.util.UUID;

public interface DefenderService {
    DefenderEntity createDefender(String name);
    DefenderEntity findDefenderByName(String name);
    void saveDefenderPosition(Defender defender, UUID userId, int waveNumber);
}
