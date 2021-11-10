package kz.onggar.collector.service.npcpack;

import kz.onggar.collector.entity.NpcPackEntity;

import java.util.UUID;

public interface NpcPackService {
    NpcPackEntity findNpcPackById(UUID id);
}
