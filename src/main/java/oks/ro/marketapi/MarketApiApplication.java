package oks.ro.marketapi;

import oks.ro.marketapi.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class MarketApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketApiApplication.class, args);
    }
}
