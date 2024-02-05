package br.com.nord.nordcrmapi.controller;

import br.com.nord.nordcrmapi.mapper.ProductMapper;
import br.com.nord.nordcrmapi.mapper.request.product.ProductPostRequest;
import br.com.nord.nordcrmapi.mapper.request.product.ProductPutRequest;
import br.com.nord.nordcrmapi.mapper.response.product.ProductGetResponse;
import br.com.nord.nordcrmapi.mapper.response.product.ProductPostResponse;
import br.com.nord.nordcrmapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/v1/product", "/api/v1/product/"})
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetResponse> findById(@PathVariable Long id) {
        var userFound = service.findById(id);
        var userConverted = mapper.productToGetResponse(userFound);
        return ResponseEntity.ok(userConverted);
    }

    @PostMapping
    public ResponseEntity<ProductPostResponse> save(@RequestBody ProductPostRequest request) {
        var userSaved = service.save(request);
        var userConverted = mapper.productToPostResponse(userSaved);
        return ResponseEntity.status(201).body(userConverted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProductPutRequest request) {
        service.update(request);
        return ResponseEntity.noContent().build();
    }

}
