package br.com.nord.api.mapper;

import br.com.nord.api.mapper.request.product.ProductPostRequest;
import br.com.nord.api.mapper.response.product.ProductGetResponse;
import br.com.nord.api.mapper.response.product.ProductPostResponse;
import br.com.nord.api.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product postToProduct(ProductPostRequest request);

    ProductPostResponse productToPostResponse(Product product);

    ProductGetResponse productToGetResponse(Product product);

}
