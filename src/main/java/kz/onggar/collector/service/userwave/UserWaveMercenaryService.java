package kz.onggar.collector.service.userwave;


import java.util.UUID;

public interface UserWaveMercenaryService {
    void saveUserWaveMercenary(UUID userId, UUID waveHistoryId, String mercenaryNpcName, int count);
}
