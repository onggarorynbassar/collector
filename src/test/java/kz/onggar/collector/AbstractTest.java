package kz.onggar.collector;

import kz.onggar.collector.entity.*;
import kz.onggar.collector.repository.NpcAbilitySetRepository;
import kz.onggar.collector.repository.UserRepository;
import kz.onggar.collector.service.npc.NpcService;
import kz.onggar.collector.service.setting.SettingService;
import kz.onggar.collector.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@AutoConfigureMockMvc
public class AbstractTest {
    public static final String TEST_USER_STEAM_ID = "testUser";

    public static final String TEST_SETTING_NAME_1 = "ts1";
    public static final int TEST_SETTING_VALUE_1 = 1;
    public static final String TEST_SETTING_NAME_2 = "ts2";
    public static final int TEST_SETTING_VALUE_2 = 2;

    public static final String TEST_NPC_NAME_1 = "dummy1";
    public static final String TEST_NPC_NAME_2 = "dummy2";
    public static final String TEST_NPC_NAME_3 = "dummy3";

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NpcAbilitySetRepository npcAbilitySetRepository;

    @Autowired
    private NpcService npcService;

    @Autowired
    private SettingService settingService;

    @Transactional
    protected UserEntity createUser(String steamId) {
        return userService.createUser(steamId);
    }

    @Transactional
    protected UserEntity createTestUserWithSettingsAndAbilitySets(String steamId) {
        var user = createUser(steamId);
        var settings = createTestSettings();
        var npcs = createTestNpcs();

        var userSetting1 = new UserSettingEntity();
        userSetting1.userEntity(user);
        userSetting1.value(TEST_SETTING_VALUE_1);
        userSetting1.settingEntity(settings.get(0));
        user.settings().add(userSetting1);

        var userSetting2 = new UserSettingEntity();
        userSetting2.userEntity(user);
        userSetting2.value(TEST_SETTING_VALUE_2);
        userSetting2.settingEntity(settings.get(1));
        user.settings().add(userSetting2);

        var abilitySets = List.of(
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(0)).option(1)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(0)).option(2)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(0)).option(3)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(1)).option(1)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(1)).option(2)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(2)).option(1)),
                npcAbilitySetRepository.save(new NpcAbilitySetEntity().npcEntity(npcs.get(2)).option(2))
        );

        abilitySets.forEach((it) -> user.npcAbilitySets().add(it));
        return userRepository.save(user);
    }

    @Transactional
    protected List<SettingEntity> createTestSettings() {
        return List.of(
                settingService.createSetting(TEST_SETTING_NAME_1),
                settingService.createSetting(TEST_SETTING_NAME_2)
        );
    }

    @Transactional
    protected List<NpcEntity> createTestNpcs() {
        return List.of(
                npcService.createNpc(TEST_NPC_NAME_1),
                npcService.createNpc(TEST_NPC_NAME_2),
                npcService.createNpc(TEST_NPC_NAME_3)
        );
    }

}
