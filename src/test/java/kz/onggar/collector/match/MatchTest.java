package kz.onggar.collector.match;

import kz.onggar.collector.AbstractTest;
import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.SteamIds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kz.onggar.collector.util.TestHelper.makePostRequest;
import static kz.onggar.collector.util.TestHelper.transformResponseToObject;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MatchTest extends AbstractTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Transactional
    void startMatchWithSinglePlayer() throws Exception {
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of("testUser"));

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
        var steamIds = new SteamIds();
        steamIds.setSteamIds(List.of("a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"));

        var startMatch = transformResponseToObject(
                makePostRequest(mvc, "/matches", steamIds, status().isOk()), MatchStart.class
        );

        assertAll("start match with new players",
                () -> assertNotNull(startMatch.getMatch()),
                () -> assertNotNull(startMatch.getUsers()),
                () -> assertTrue(startMatch.getUsers().stream().allMatch(user -> steamIds.getSteamIds().contains(user.getSteamId())))
        );
    }
}
