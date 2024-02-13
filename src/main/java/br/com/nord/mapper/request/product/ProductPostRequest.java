package br.com.nord.mapper.request.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPostRequest {

    private String name;

    private String supplier;

    private String category;

    private String description;

}
