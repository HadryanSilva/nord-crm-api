package br.com.nord.mapper;

import br.com.nord.mapper.request.product.ProductPostRequest;
import br.com.nord.mapper.request.product.ProductPutRequest;
import br.com.nord.mapper.response.product.ProductGetResponse;
import br.com.nord.mapper.response.product.ProductPostResponse;
import br.com.nord.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product postToProduct(ProductPostRequest request);

    Product putToProduct(ProductPutRequest request);

    ProductGetResponse productToGetResponse(Product product);

    ProductPostResponse productToPostResponse(Product product);

    List<ProductGetResponse> productToGetResponseList(List<Product> products);

}
