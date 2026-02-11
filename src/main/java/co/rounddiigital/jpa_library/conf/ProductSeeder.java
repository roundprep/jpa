package co.rounddiigital.jpa_library.conf;

import co.rounddiigital.jpa_library.dao.ProductRepo;
import co.rounddiigital.jpa_library.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(5)
public class ProductSeeder {
    private ProductRepo productRepo;
    //Constructor Injection
    public ProductSeeder(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    // bean life cycle method ( init, destroy)

    @PostConstruct
    public void initializeProducts() {
        System.out.println("Seeding Products");
        productRepo.saveAll(
                Arrays.asList(
                        Product.builder().name("Lenovo - Notebook").price(299).build(),
                        Product.builder().name("HP - Notebook").price(399).build(),
                        Product.builder().name("Mac - Pro").price(1299).build(),
                        Product.builder().name("Samsumg - Notebook").price(499).build(),
                        Product.builder().name("Acer - LightBook").price(799).build()
                )
        );
    }
}
