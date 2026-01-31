package co.rounddiigital.jpa_library.service;

import co.rounddiigital.jpa_library.dao.ProductRepo;
import co.rounddiigital.jpa_library.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product create(Product product) {
        return productRepo.save(product);
    }

    public Product update(Product product) {
        return productRepo.save(product);
    }
    public void deleteById(UUID product) {
        productRepo.deleteById(product);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }
    public Product findById(UUID id) {
        return productRepo.findById(id).orElse(null);
    }

}
