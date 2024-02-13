package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.model.Customer;
import br.com.nord.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService {

    private final CustomerRepository repository;

    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    public Customer save(Customer customer) {
        log.info("Saving customer");
        return repository.save(customer);
    }

    public void delete(Long id) {
        var customerFound = findById(id);
        log.info("Deleting customer with id {}", id);
        repository.delete(customerFound);
        log.info("Customer with id {} deleted successfully", id);
    }

    public void update(Customer customer) {
        var customerFound = findById(customer.getId());
        assertCustomerExists(customer);
        log.info("Updating customer with id {}", customer.getId());
        repository.save(customerFound);
        log.info("Customer with id {} updated successfully", customer.getId());
    }

    public void assertCustomerExists(Customer customer) {
        findById(customer.getId());
    }

}
