package co.rounddiigital.jpa_library.service;

import co.rounddiigital.jpa_library.dao.CustomerRepo;
import co.rounddiigital.jpa_library.entity.Customer;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer create(Customer customer) {
        return customerRepo.save(customer);
    }
    public Customer update(Customer customer) {
        return customerRepo.save(customer);
    }
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

    public void delete(UUID id) {
        customerRepo.deleteById(id);
    }
    public Optional<Customer> findById(UUID id) {
        return customerRepo.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
