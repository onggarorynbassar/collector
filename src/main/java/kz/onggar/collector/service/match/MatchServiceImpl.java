package kz.onggar.collector.service.match;


import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.entity.WaveHistoryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.mapper.UserMapper;
import kz.onggar.collector.openapi.dto.*;
import kz.onggar.collector.repository.MatchRepository;
import kz.onggar.collector.service.defender.DefenderService;
import kz.onggar.collector.service.mercenary.MercenaryService;
import kz.onggar.collector.service.mercenary.MercenarySpellService;
import kz.onggar.collector.service.npc.NpcAbilitySetService;
import kz.onggar.collector.service.npc.NpcPackService;
import kz.onggar.collector.service.user.UserService;
import kz.onggar.collector.service.wave.WaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final UserService userService;
    private final DefenderService defenderService;
    private final MercenaryService mercenaryService;
    private final MercenarySpellService mercenarySpellService;
    private final WaveService waveService;
    private final NpcPackService npcPackService;
    private final NpcAbilitySetService npcAbilitySetService;

    public MatchServiceImpl(
            MatchRepository matchRepository,
            UserService userService,
            DefenderService defenderService,
            MercenaryService mercenaryService,
            MercenarySpellService mercenarySpellService,
            WaveService waveService,
            NpcPackService npcPackService,
            NpcAbilitySetService npcAbilitySetService
    ) {
        this.matchRepository = matchRepository;
        this.userService = userService;
        this.defenderService = defenderService;
        this.mercenaryService = mercenaryService;
        this.mercenarySpellService = mercenarySpellService;
        this.waveService = waveService;
        this.npcPackService = npcPackService;
        this.npcAbilitySetService = npcAbilitySetService;
    }

    @Override
    @Transactional
    public MatchStart save(SteamIds ids) {
        var newMatch = matchRepository.save(new MatchEntity());

        List<User> foundOrCreatedUsers = ids.getSteamIds()
                .stream()
                .map(steamId ->
                        userService.getUserEntityBySteamId(steamId)
                                .orElseGet(() -> userService.createUser(steamId))
                )
                .map(UserMapper::toDto)
                .collect(Collectors.toList());

        return new MatchStart()
                .match(new Match().id(newMatch.id()))
                .users(foundOrCreatedUsers);
    }

    @Override
    @Transactional(readOnly = true)
    public MatchEntity getMatchEntity(UUID id) {
        return matchRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Match entity with id=[%s] not found".formatted(id))
        );
    }


    private void saveDefenderPosition(UserMatchStatus userMatchStatus, int waveNumber) {
        userMatchStatus
                .getDefenders()
                .forEach(defender -> defenderService
                        .saveDefenderPosition(defender, userMatchStatus.getPlayerId(), waveNumber)
                );
    }

    private void saveMercenaries(UserMatchStatus userMatchStatus, UUID waveHistoryId) {
        userMatchStatus
                .getMercenaries()
                .forEach(mercenary -> mercenaryService
                        .saveWaveMercenary(userMatchStatus.getPlayerId(), waveHistoryId, mercenary.getName(), mercenary.getCount()));
    }

    private void saveMercenariesSpells(UserMatchStatus userMatchStatus, UUID waveHistoryId) {
        userMatchStatus
                .getSpells()
                .forEach(spell -> mercenarySpellService
                        .saveWaveMercenarySpell(userMatchStatus.getPlayerId(), waveHistoryId, spell.getName()));
    }


    private void saveWaveAbilitySet(UserMatchStatus userMatchStatus, WaveHistoryEntity waveHistoryEntity, String npcName) {
        npcAbilitySetService.saveWaveAbilitySet(
                userMatchStatus.getPlayerId(),
                waveHistoryEntity.id(),
                npcName,
                userMatchStatus.getNpcAbilitySetOption());
    }


    @Override
    @Transactional
    public void update(MatchUpdate matchUpdate) {
        var matchEntity = getMatchEntity(matchUpdate.getMatchId());
        matchEntity.currentWave(matchUpdate.getWave());

        var waveHistory = waveService.createWaveHistory(
                getMatchEntity(matchUpdate.getMatchId()),
                npcPackService.findNpcPackByNpcName(matchUpdate.getNpcName()).id(),
                waveService.findWaveByRoundNumber(matchUpdate.getWave())
        );

        matchUpdate.getUserMatchStatuses()
                .forEach(userMatchStatus -> {
                            saveDefenderPosition(userMatchStatus, matchUpdate.getWave());
                            saveMercenaries(userMatchStatus, waveHistory.id());
                            saveMercenariesSpells(userMatchStatus, waveHistory.id());
                            saveWaveAbilitySet(userMatchStatus, waveHistory, matchUpdate.getNpcName());
                        }
                );

        matchRepository.save(matchEntity);
    }
}