package kz.onggar.collector;

import kz.onggar.collector.configuration.CompetitiveRatingConfiguration;
import kz.onggar.collector.configuration.RelativeRatingConfiguration;
import kz.onggar.collector.configuration.SimpleRatingConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static kz.onggar.collector.component.LobbyPlayerCount.COMMON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectorApplicationTests {
    @Autowired
    private RelativeRatingConfiguration relativeRatingScoreDistributionConfiguration;
    @Autowired
    private SimpleRatingConfiguration simpleRatingConfiguration;
    @Autowired
    private CompetitiveRatingConfiguration competitiveRatingConfiguration;

    @Test
    public void whenYamlFileProvidedThenInjectSimpleMap() {
        assertThat(relativeRatingScoreDistributionConfiguration.getScoreDistribution().get(COMMON.name())).containsOnlyKeys(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(simpleRatingConfiguration.getScoreDistribution().get(COMMON.name())).containsOnlyKeys(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(competitiveRatingConfiguration.getScoreDistribution().get(COMMON.name())).containsOnlyKeys(1, 2, 3, 4, 5, 6, 7, 8);
    }
}
