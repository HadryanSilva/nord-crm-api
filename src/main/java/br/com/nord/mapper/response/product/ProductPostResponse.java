package br.com.nord.mapper.response.product;

import br.com.nord.enums.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPostResponse {

    private String name;

    private String supplier;

    private ProductCategory productCategory;

    private String description;

}
