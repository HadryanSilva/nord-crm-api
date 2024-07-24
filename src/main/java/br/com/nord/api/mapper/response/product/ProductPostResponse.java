package br.com.nord.api.mapper.response.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPostResponse {

    private Long id;
    private String name;
    private String supplier;
    private String category;
    private String description;

}
