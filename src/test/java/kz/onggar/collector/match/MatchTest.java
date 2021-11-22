package kz.onggar.collector.match;

import kz.onggar.collector.AbstractTest;
import kz.onggar.collector.openapi.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kz.onggar.collector.util.TestHelper.*;
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

    private boolean testPlayerDefenders(List<UserMatchStatus> users) {
        for (UserMatchStatus user : users) {
            for (Defender defender : user.getDefenders()) {
                var optionalDefender = defenderService.findDefenderByName(defender.getName());
                if (optionalDefender.name() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean testMercenaries(List<UserMatchStatus> users) {
        for (UserMatchStatus user : users) {
            for (Mercenary mercenary : user.getMercenaries()) {
                var optionalMercenary = mercenaryService.getMercenaryByName(mercenary.getName());
                if (optionalMercenary.name() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean testMercenarySpells(List<UserMatchStatus> users) {
        for (UserMatchStatus user : users) {
            for (MercenarySpell mercenarySpell : user.getSpells()) {
                var optionalMercenarySpell = mercenarySpellService.getMercenarySpellByName(mercenarySpell.getName());
                if (optionalMercenarySpell.name() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    @Transactional
    void updateMatchWithPerfectData() throws Exception {
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of("a1", "a2", TEST_USER_STEAM_ID, "a4", "a5", "a6", "a7", "a8"));

        var startMatch = createMatch(steamIds);
        var testNpcs = createTestNpcs();
        createTestWaves();
        createTestNpcPacks(testNpcs);
        createTestNpcAbilitySets(testNpcs);

        var defendersDTO = createTestDefendersDTO();
        var mercenariesDTO = createTestMercenariesDTO();
        var spellsDTO = createTestSpellsDTO();

        var matchUpdate = new MatchUpdate();
        matchUpdate.setMatchId(startMatch.getMatch().getId());
        matchUpdate.setNpcName(testNpcs.get(0).name());
        matchUpdate.setWave(15);
        matchUpdate.setUserMatchStatuses(createMockUserMatchStatuses(startMatch, defendersDTO, mercenariesDTO, spellsDTO));

        makePutRequest(mvc, "/matches", matchUpdate, status().isOk());

        assertAll("starting and updating match with perfect values",
                () -> assertNotNull(matchService.getMatchEntity(startMatch.getMatch().getId())),
                () -> assertEquals(matchService.getMatchEntity(startMatch.getMatch().getId()).id(), startMatch.getMatch().getId()),
                () -> assertEquals(testNpcs, npcService.findAllNpcs()),
                () -> assertEquals(npcService.getByName(testNpcs.get(0).name()).name(), testNpcs.get(0).name()),
                () -> assertEquals(waveService.findWaveByRoundNumber(15).roundNumber(), 15),
                () -> assertFalse(userService.getAllUsers().isEmpty()),
                () -> assertTrue(testPlayerDefenders(matchUpdate.getUserMatchStatuses())),
                () -> assertTrue(testMercenaries(matchUpdate.getUserMatchStatuses())),
                () -> assertTrue(testMercenarySpells(matchUpdate.getUserMatchStatuses()))
        );
    }
}
