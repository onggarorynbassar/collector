package kz.onggar.collector.service.npc;

import kz.onggar.collector.entity.NpcEntity;
import kz.onggar.collector.entity.NpcPackEntity;

import java.util.UUID;

public interface NpcPackService {
    NpcPackEntity findNpcPackById(UUID id);

    NpcPackEntity findNpcPackByNpcName(String name);

    NpcPackEntity createNpcPack(NpcEntity npcEntity, int count);
}
