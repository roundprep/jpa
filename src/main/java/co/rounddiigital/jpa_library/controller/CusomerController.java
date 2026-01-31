package co.rounddiigital.jpa_library.controller;

import co.rounddiigital.jpa_library.entity.Customer;
import co.rounddiigital.jpa_library.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CusomerController {
    private CustomerService service;
    public CusomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/api/customer")
    public Customer create(@RequestBody Customer customer) {
       return service.create(customer);
    }

    @PutMapping("/api/customer")
    public  Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @GetMapping("/api/customer")
    public List<Customer> findAll() {
        return service.findAll();
    }

}
