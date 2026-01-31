package co.rounddiigital.jpa_library.service;

import co.rounddiigital.jpa_library.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProductServiceTest {
    @Mock
    private ProductService service;

    @Test()
    void createProduct() {
        Product product = service.create(new Product());
        Assertions.assertNotNull(product.getId());
    }
}
