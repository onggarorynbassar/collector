package kz.onggar.collector.service.npc;

import kz.onggar.collector.entity.NpcEntity;
import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.MatchUpdate;
import kz.onggar.collector.openapi.dto.SteamIds;

public interface NpcService {
    NpcEntity createNpc(String name);
    NpcEntity getByName(String name);
}
