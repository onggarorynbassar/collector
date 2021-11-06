package kz.onggar.collector.service.mercenary;

import kz.onggar.collector.repository.MercenaryRepository;
import kz.onggar.collector.repository.MercenarySpellRepository;
import org.springframework.stereotype.Service;

@Service
public class MercenarySpellImpl implements MercenaryService {
    MercenarySpellRepository mercenarySpellRepository;
}