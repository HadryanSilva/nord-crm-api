package br.com.nord.nordcrmapi.mapper.request.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPutRequest {

    private Long id;

    private String name;

    private String supplier;

    private String productCategory;

    private String description;

}
