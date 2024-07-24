package br.com.nord.api.service;

import br.com.nord.api.mapper.CustomerMapper;
import br.com.nord.api.mapper.request.customer.CustomerPostRequest;
import br.com.nord.api.mapper.response.customer.CustomerGetResponse;
import br.com.nord.api.mapper.response.customer.CustomerPostResponse;
import br.com.nord.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerGetResponse> findAll(int page, int size) {
        log.info("Finding all customers");
        return customerRepository.findAll(PageRequest.of(page, size)).getContent()
                .stream()
                .map(customerMapper::customerToGetResponse)
                .toList();
    }

    public CustomerPostResponse save(CustomerPostRequest request) {
        log.info("Saving customer: {}", request);
        var customer = customerRepository.save(customerMapper.postToCustomer(request));
        return customerMapper.customerToPostResponse(customer);
    }

    public void delete(Long id) {
        log.info("Deleting customer with id: {}", id);
        customerRepository.deleteById(id);
    }

    public void update(Long id, CustomerPostRequest request) {
        log.info("Updating customer with id: {}", id);
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFullName(request.getFullName());
        customer.setCpf_cnpj(request.getCpf_cnpj());
        customer.setEmail(request.getEmail());
        customer.setPersonType(request.getPersonType());
        customer.setBornDate(request.getBornDate());
        customer.setAddress(request.getAddress());
        customerRepository.save(customer);
    }


}
