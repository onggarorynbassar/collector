package kz.onggar.collector.service.defender;

import kz.onggar.collector.entity.DefenderEntity;

import java.util.UUID;

public interface DefenderService {
    void createDefender(String name);

    DefenderEntity findDefenderByName(String name);
}
