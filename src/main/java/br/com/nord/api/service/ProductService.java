package br.com.nord.api.service;

import br.com.nord.api.mapper.ProductMapper;
import br.com.nord.api.mapper.request.product.ProductPostRequest;
import br.com.nord.api.mapper.response.product.ProductGetResponse;
import br.com.nord.api.mapper.response.product.ProductPostResponse;
import br.com.nord.api.model.Product;
import br.com.nord.api.model.enums.ProductCategory;
import br.com.nord.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductGetResponse> findAll(int page, int size) {
        log.info("Finding all products");
        return productRepository.findAll(PageRequest.of(page, size))
                .map(productMapper::productToGetResponse)
                .getContent();
    }

    public ProductPostResponse save(ProductPostRequest request) {
        log.info("Saving product: {}", request);
        Product product = productMapper.postToProduct(request);
        productRepository.save(product);
        return productMapper.productToPostResponse(product);
    }

    public void delete(Long id) {
        log.info("Deleting product with id: {}", id);
        productRepository.deleteById(id);
    }

    public void update(Long id, ProductPostRequest request) {
        log.info("Updating product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow();
        product.setName(request.getName());
        product.setSupplier(request.getSupplier());
        product.setCategory(ProductCategory.valueOf(request.getCategory()));
        product.setDescription(request.getDescription());
        productRepository.save(product);
    }

}
