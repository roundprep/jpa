package co.rounddiigital.jpa_library.conf;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Order(2)
public class AppFirstConfig {
    public AppFirstConfig() {
    }

    @PostConstruct
    public void intialize() {
        System.out.println("intialize---first");
    }
}
