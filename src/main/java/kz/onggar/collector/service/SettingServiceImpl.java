package kz.onggar.collector.service;

import kz.onggar.collector.entity.SettingEntity;
import kz.onggar.collector.repository.SettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettingServiceImpl implements SettingService {

    SettingRepository settingRepository;

    public SettingServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    @Transactional
    public SettingEntity createSetting(String name) {
        return settingRepository.save(
                new SettingEntity().name(name)
        );
    }
}