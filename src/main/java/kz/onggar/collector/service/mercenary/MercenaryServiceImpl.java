package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.SettingEntity;
import kz.onggar.collector.repository.MercenaryRepository;
import kz.onggar.collector.service.setting.SettingService;
import org.springframework.stereotype.Service;

@Service
public class MercenaryServiceImpl implements MercenaryService {

    MercenaryRepository mercenaryNpcRepository;
}