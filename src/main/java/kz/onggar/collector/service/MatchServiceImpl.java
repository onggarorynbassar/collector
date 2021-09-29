package kz.onggar.collector.service;


import kz.onggar.collector.dto.MatchResult;
import kz.onggar.collector.entity.MatchEntity;
import kz.onggar.collector.repository.MatchResultRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MatchServiceImpl implements MatchService {


    MatchResultRepository matchResultRepository;

    public MatchServiceImpl(MatchResultRepository matchResultRepository) {
        this.matchResultRepository = matchResultRepository;
    }

    @Override
    @Transactional
    public void saveMatchResult(MatchResult matchResult) {
        MatchEntity matchEntity = new MatchEntity();
    }
}
