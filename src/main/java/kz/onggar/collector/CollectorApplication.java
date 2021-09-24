package kz.onggar.collector;

import kz.onggar.collector.component.LobbyPlayerCount;
import kz.onggar.collector.service.RelativeRatingCalculatorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectorApplication.class, args);
    }

}
