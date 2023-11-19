package tn.esprit.esprittwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EspritTwinApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspritTwinApplication.class, args);
    }

}
