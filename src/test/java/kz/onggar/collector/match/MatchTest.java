package kz.onggar.collector.match;

import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.SteamIds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kz.onggar.collector.util.TestHelper.makePostRequest;
import static kz.onggar.collector.util.TestHelper.transformResponseToObject;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@AutoConfigureMockMvc
class MatchTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void init() {
    }

    @Test
    @Transactional
    void saveMatchResultTest() throws Exception {

        var steamIds = new SteamIds();
        var steamIdTestValues = List.of("t1", "t2", "t3", "t4", "t5");

        steamIds.setSteamIds(steamIdTestValues);

        var startedMatch = transformResponseToObject(
                makePostRequest(mvc, "/matches", steamIds, status().is2xxSuccessful()),
                MatchStart.class
        );

        assertAll("check that match have been created",
                () -> assertNotNull(startedMatch),
                () -> assertNotNull(startedMatch.getUsers()),
                () -> assertNotNull(startedMatch.getMatch())

        );
    }
}
