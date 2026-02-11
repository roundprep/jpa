package co.rounddiigital.jpa_library.conf;

import co.rounddiigital.jpa_library.dao.CustomerRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class CustomerSeeder {
    private CustomerRepo customerRepo;

    public CustomerSeeder(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostConstruct
    public void seedCustomers() {
        System.out.println("Seeding customers");
    }
}
