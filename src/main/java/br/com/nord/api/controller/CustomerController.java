package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.customer.CustomerPostRequest;
import br.com.nord.api.mapper.response.customer.CustomerGetResponse;
import br.com.nord.api.mapper.response.customer.CustomerPostResponse;
import br.com.nord.api.model.Customer;
import br.com.nord.api.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerGetResponse>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                             @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(customerService.findAll(page, size));
    }

    @PostMapping
    public ResponseEntity<CustomerPostResponse> save(@RequestBody CustomerPostRequest request) {
        var response = customerService.save(request);
        return ResponseEntity
                .created(URI.create("/api/v1/customers/" + response.getId()))
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestBody CustomerPostRequest request) {
        customerService.update(id, request);
    }

}
