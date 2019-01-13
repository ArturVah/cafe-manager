package am.artyshok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
public class CafeManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(CafeManagerApp.class, args);
    }
}
