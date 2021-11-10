package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.entity.MercenaryEntity;

public interface MercenaryService {
    MercenaryEntity getMercenaryByName(String name);
}
