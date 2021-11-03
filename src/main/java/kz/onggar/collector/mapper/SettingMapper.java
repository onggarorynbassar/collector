package kz.onggar.collector.mapper;

import kz.onggar.collector.entity.UserEntity;
import kz.onggar.collector.entity.UserSettingEntity;
import kz.onggar.collector.openapi.dto.User;
import kz.onggar.collector.openapi.dto.UserSetting;

public class SettingMapper {
    public static UserSetting toDto(UserSettingEntity userSettingEntity) {
        return new UserSetting()
                .name(userSettingEntity.settingEntity().name())
                .value(userSettingEntity.value());
    }
}
