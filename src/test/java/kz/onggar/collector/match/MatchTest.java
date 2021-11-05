package kz.onggar.collector.match;

import kz.onggar.collector.AbstractTest;
import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.SteamIds;
import kz.onggar.collector.openapi.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kz.onggar.collector.util.TestHelper.makePostRequest;
import static kz.onggar.collector.util.TestHelper.transformResponseToObject;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MatchTest extends AbstractTest {

    @Test
    @Transactional
    void startMatchWithSinglePlayer() throws Exception {
        createTestUserWithSettingsAndAbilitySets(TEST_USER_STEAM_ID);
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of(TEST_USER_STEAM_ID));

        var startMatch = transformResponseToObject(
                makePostRequest(mvc, "/matches", steamIds, status().isOk()), MatchStart.class
        );

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

        var startMatch = transformResponseToObject(
                makePostRequest(mvc, "/matches", steamIds, status().isOk()), MatchStart.class
        );

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
}
