package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.model.Product;
import br.com.nord.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository repository;

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public Product save(Product productToSave) {
        log.info("Saving product");
        return repository.save(productToSave);
    }

    public void delete(Long id) {
        var product = findById(id);
        log.info("Deleting product with id {}", id);
        repository.delete(product);
        log.info("Product deleted successfully");
    }

    public void update(Product productToUpdate) {
        assertProductExists(productToUpdate);
        log.info("Updating product with id {}", productToUpdate.getId());
        repository.save(productToUpdate);
        log.info("Product updated successfully");
    }

    private void assertProductExists(Product product) {
        findById(product.getId());
    }

}
