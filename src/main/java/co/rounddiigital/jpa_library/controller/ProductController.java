package co.rounddiigital.jpa_library.controller;

import co.rounddiigital.jpa_library.entity.Product;
import co.rounddiigital.jpa_library.model.ErrorResponse;
import co.rounddiigital.jpa_library.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public String findAllProducts(Model model) {
        List<Product> all = service.findAll();
        System.out.println("All products: " + all);

        model.addAttribute("products", all);
        return "product";
    }
    // ResponseEntity
    @PostMapping("/api/products")
    @ResponseBody
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-PRODUCT-MARKET", "IN")
                .body(service.create(product));
    }

    @GetMapping("/api/products/{id}")

    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        Optional<Product> result = service.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }else {
            ErrorResponse response
                     = ErrorResponse.builder()
                    .errorCode("API-404")
                    .errorMessage("Product not found for ID"+ id.toString())
                    .errorTimestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }
}
