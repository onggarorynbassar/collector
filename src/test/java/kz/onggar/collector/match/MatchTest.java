package kz.onggar.collector.match;

import kz.onggar.collector.AbstractTest;
import kz.onggar.collector.entity.MercenaryEntity;
import kz.onggar.collector.exception.ResourceNotFoundException;
import kz.onggar.collector.openapi.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static kz.onggar.collector.util.TestHelper.makePostRequest;
import static kz.onggar.collector.util.TestHelper.transformResponseToObject;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MatchTest extends AbstractTest {


    private MatchStart createMatch(SteamIds steamIds) throws Exception {
        return transformResponseToObject(
                makePostRequest(mvc, "/matches", steamIds, status().isOk()), MatchStart.class
        );
    }

    @Test
    @Transactional
    void startMatchWithSinglePlayer() throws Exception {
        createTestUserWithSettingsAndAbilitySets(TEST_USER_STEAM_ID);
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of(TEST_USER_STEAM_ID));

        var startMatch = createMatch(steamIds);

        assertAll("start match with known player",
                () -> assertNotNull(startMatch.getMatch()),
                () -> assertNotNull(startMatch.getUsers()),
                () -> assertTrue(startMatch.getUsers().stream().allMatch(user -> steamIds.getSteamIds().contains(user.getSteamId())))
        );
    }

    @Test
    @Transactional
    void startMatchTest() throws Exception {
        createTestUserWithSettingsAndAbilitySets(TEST_USER_STEAM_ID);
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of("a1", "a2", TEST_USER_STEAM_ID, "a4", "a5", "a6", "a7", "a8"));

        var startMatch = createMatch(steamIds);

        var userWithSettings = startMatch.getUsers()
                .stream()
                .filter((user) -> user.getSteamId().equals(TEST_USER_STEAM_ID))
                .findFirst().orElseGet(User::new);

        assertAll("start match with new players",
                () -> assertNotNull(startMatch.getMatch()),
                () -> assertNotNull(startMatch.getUsers()),
                () -> assertTrue(startMatch.getUsers().stream().allMatch(user -> steamIds.getSteamIds().contains(user.getSteamId()))),
                () -> assertTrue(startMatch.getUsers().stream().allMatch(user -> user.getId() != null)),
                () -> assertFalse(userWithSettings.getSettings().isEmpty()),
                () -> assertFalse(userWithSettings.getNpcAbilitySets().isEmpty())
        );
    }

    @Test
    @Transactional
    void updateMatchWithPerfectData() throws Exception {
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of("a1", "a2", TEST_USER_STEAM_ID, "a4", "a5", "a6", "a7", "a8"));

        var startMatch = createMatch(steamIds);
        var createNpc = createTestNpcs();

        var defendersDTO = createDefenders().stream().map(defender -> {
            var newDefender = new Defender();

            newDefender.setName(defender.name());
            newDefender.setPositionX(0);
            newDefender.setPositionY(0);

            return newDefender;
        }).collect(Collectors.toList());

        var mercenariesDTO = createMercenaries().stream().map(mercenary -> {
            var newMercenary = new Mercenary();
            newMercenary.name(mercenary.name());
            newMercenary.count(10);

            return newMercenary;
        }).collect(Collectors.toList());

        var spellsDTO = createMercenarySpells().stream().map(spell -> {
            var newSpell = new MercenarySpell();
            newSpell.setName(spell.name());

            return newSpell;
        }).collect(Collectors.toList());

        var userMatchStatuses = new ArrayList<UserMatchStatus>();

        startMatch.getUsers().forEach(user -> {

            var userMatchStatus = new UserMatchStatus();

            userMatchStatus.setPlayerId(user.getId());
            userMatchStatus.setAlive(true);
            userMatchStatus.setDefenders(defendersDTO);
            userMatchStatus.setMercenaries(mercenariesDTO);
            userMatchStatus.setSpells(spellsDTO);
            userMatchStatus.setNpcAbilitySetOption(0);

            userMatchStatuses.add(userMatchStatus);
        });

        var matchUpdate = new MatchUpdate();
        matchUpdate.setMatchId(startMatch.getMatch().getId());
        matchUpdate.setNpcName(createNpc.get(0).name());
        matchUpdate.setWave(15);
        matchUpdate.setUserMatchStatuses(userMatchStatuses);


        makePostRequest(mvc, "/matches", matchUpdate, status().isOk());


//        assertAll("updating match with perfect values",
//
//                () ->
//
//        );

        //TODO assertEquals database values with mock values

    }
}
