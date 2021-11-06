package kz.onggar.collector.service.defender;

import kz.onggar.collector.openapi.dto.Defender;

import java.util.UUID;

public interface DefenderPositionService {
    void saveDefenderPosition(Defender defender, UUID userId, int waveNumber);
}
