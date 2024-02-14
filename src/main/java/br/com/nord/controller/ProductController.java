package br.com.nord.controller;

import br.com.nord.mapper.ProductMapper;
import br.com.nord.mapper.request.product.ProductPostRequest;
import br.com.nord.mapper.request.product.ProductPutRequest;
import br.com.nord.mapper.response.product.ProductGetResponse;
import br.com.nord.mapper.response.product.ProductPostResponse;
import br.com.nord.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1/product", "/api/v1/product/"})
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductGetResponse>> findAll() {
        var products = service.findAll();
        var convertedList = mapper.productToGetResponseList(products);
        return ResponseEntity.ok(convertedList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetResponse> findById(@PathVariable Long id) {
        var userFound = service.findById(id);
        var userConverted = mapper.productToGetResponse(userFound);
        return ResponseEntity.ok(userConverted);
    }

    @PostMapping
    public ResponseEntity<ProductPostResponse> save(@RequestBody ProductPostRequest request) {
        var userToSave = mapper.postToProduct(request);
        var userSaved = service.save(userToSave);
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
        var productToUpdate = mapper.putToProduct(request);
        service.update(productToUpdate);
        return ResponseEntity.noContent().build();
    }

}
