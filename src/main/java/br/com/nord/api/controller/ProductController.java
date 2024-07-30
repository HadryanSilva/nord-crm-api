package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.product.ProductPostRequest;
import br.com.nord.api.mapper.response.product.ProductGetResponse;
import br.com.nord.api.mapper.response.product.ProductPostResponse;
import br.com.nord.api.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductGetResponse>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                            @RequestParam(name = "size", defaultValue = "10") int size) {
        var response = productService.findAll(page, size);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductPostResponse> save(@RequestBody ProductPostRequest request) {
        var response = productService.save(request);
        return ResponseEntity
                .created(URI.create("/api/v1/products/" + response.getId()))
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody ProductPostRequest request) {
        productService.update(id, request);
        return ResponseEntity.noContent().build();
    }

}
