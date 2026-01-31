package co.rounddiigital.jpa_library.controller;

import co.rounddiigital.jpa_library.entity.Product;
import co.rounddiigital.jpa_library.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @PostMapping("/api/products")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }
}
