package co.rounddiigital.jpa_library.service;

import co.rounddiigital.jpa_library.dao.ProductRepo;
import co.rounddiigital.jpa_library.entity.Product;
import co.rounddiigital.jpa_library.exception.InvalidProductNameException;
import co.rounddiigital.jpa_library.exception.InvalidProductPriceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product create(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(product.getName() == null || product.getName().isEmpty()
                || product.getName().length()<= 5) {
            throw new InvalidProductNameException("Product name is null or less than 5 chars");
        }
        if (product.getPrice() <=0) {
            throw new InvalidProductPriceException("Product price is invalid");
        }
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
    public Optional<Product> findById(UUID id) {
        return productRepo.findById(id);
    }

}
