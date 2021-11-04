package kz.onggar.collector;

import kz.onggar.collector.entity.SettingEntity;
import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.service.MatchService;
import kz.onggar.collector.service.SettingService;
import kz.onggar.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@AutoConfigureMockMvc
public class AbstractTest {

    public static final String TEST_USER_STEAM_ID = "testUser";

    public static final String TEST_SETTING_NAME_1 = "ts1";
    public static final String TEST_SETTING_VALUE_1 = "tsv1";
    public static final String TEST_SETTING_NAME_2 = "ts2";
    public static final String TEST_SETTING_VALUE_2 = "tsv1";

    @Autowired
    private UserService userService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private SettingService settingService;


    @Transactional
    protected UserEntity createTestUser() {
        var user = userService.createUser(TEST_USER_STEAM_ID);
        var settings = createSettings();
    }

    @Transactional
    protected List<SettingEntity> createSettings() {
        return List.of(
                settingService.createSetting(TEST_SETTING_NAME_1),
                settingService.createSetting(TEST_SETTING_NAME_2)
        );
    }

}
