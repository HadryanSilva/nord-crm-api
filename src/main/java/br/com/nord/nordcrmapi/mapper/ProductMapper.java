package br.com.nord.nordcrmapi.mapper;

import br.com.nord.nordcrmapi.mapper.request.product.ProductPostRequest;
import br.com.nord.nordcrmapi.mapper.request.product.ProductPutRequest;
import br.com.nord.nordcrmapi.mapper.response.product.ProductGetResponse;
import br.com.nord.nordcrmapi.mapper.response.product.ProductPostResponse;
import br.com.nord.nordcrmapi.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product postToProduct(ProductPostRequest request);

    Product putToProduct(ProductPutRequest request);

    ProductGetResponse productToGetResponse(Product product);

    ProductPostResponse productToPostResponse(Product product);

}
