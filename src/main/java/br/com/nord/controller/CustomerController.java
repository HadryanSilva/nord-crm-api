package br.com.nord.controller;

import br.com.nord.mapper.CustomerMapper;
import br.com.nord.mapper.request.customer.CustomerPostRequest;
import br.com.nord.mapper.response.customer.CustomerGetResponse;
import br.com.nord.mapper.response.customer.CustomerPostResponse;
import br.com.nord.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/v1/customer", "/api/v1/customer/"})
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerGetResponse> findById(@PathVariable Long id) {
        var customerFound = customerService.findById(id);
        var customerConverted = mapper.customerToGetResponse(customerFound);
        return ResponseEntity.ok(customerConverted);
    }

    @PostMapping
    public ResponseEntity<CustomerPostResponse> save(@RequestBody @Valid CustomerPostRequest request) {
        var customerConverted = mapper.postToCustomer(request);
        var customerSaved = customerService.save(customerConverted);
        return ResponseEntity.status(201).body(mapper.customerToPostResponse(customerSaved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(CustomerPostRequest request) {
        var customerConverted = mapper.postToCustomer(request);
        customerService.update(customerConverted);
        return ResponseEntity.noContent().build();
    }

}
