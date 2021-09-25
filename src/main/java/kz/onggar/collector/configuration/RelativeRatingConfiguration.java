package kz.onggar.collector.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("rating.relative")
public class RelativeRatingConfiguration {
    private int max;
    private int min;
    private Map<String, Map<Integer, Integer>> scoreDistribution;

    public int getMax() {
        return max;
    }

    public RelativeRatingConfiguration setMax(int max) {
        this.max = max;
        return this;
    }

    public int getMin() {
        return min;
    }

    public RelativeRatingConfiguration setMin(int min) {
        this.min = min;
        return this;
    }

    public Map<String, Map<Integer, Integer>> getScoreDistribution() {
        return scoreDistribution;
    }

    public RelativeRatingConfiguration setScoreDistribution(Map<String, Map<Integer, Integer>> scoreDistribution) {
        this.scoreDistribution = scoreDistribution;
        return this;
    }
}
