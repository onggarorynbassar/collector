package kz.onggar.collector;

import kz.onggar.collector.configuration.RelativeRatingConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static kz.onggar.collector.component.LobbyPlayerCount.COMMON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectorApplicationTests {
    @Autowired
    private RelativeRatingConfiguration relativeRatingScoreDistributionConfiguration;

    @Test
    public void whenYamlFileProvidedThenInjectSimpleMap() {
        assertThat(relativeRatingScoreDistributionConfiguration.getScoreDistribution().get(COMMON.name()))
                .isNotEmpty();
        assertThat(relativeRatingScoreDistributionConfiguration.getScoreDistribution().get(COMMON.name()))
                .containsOnlyKeys(1, 2, 3, 4, 5, 6, 7, 8);
    }
}
