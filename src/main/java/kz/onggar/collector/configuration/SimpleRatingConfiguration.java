package kz.onggar.collector.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("rating.simple")
public class SimpleRatingConfiguration {
    private int max;
    private int min;
    private Map<String, Map<Integer, Integer>> scoreDistribution;

    public int getMax() {
        return max;
    }

    public SimpleRatingConfiguration setMax(int max) {
        this.max = max;
        return this;
    }

    public int getMin() {
        return min;
    }

    public SimpleRatingConfiguration setMin(int min) {
        this.min = min;
        return this;
    }

    public Map<String, Map<Integer, Integer>> getScoreDistribution() {
        return scoreDistribution;
    }

    public SimpleRatingConfiguration setScoreDistribution(Map<String, Map<Integer, Integer>> scoreDistribution) {
        this.scoreDistribution = scoreDistribution;
        return this;
    }
}
