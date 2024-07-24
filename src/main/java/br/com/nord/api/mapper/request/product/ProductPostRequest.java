package br.com.nord.api.mapper.request.product;

import br.com.nord.api.model.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductPostRequest {

    private String name;
    private String supplier;
    private String category;
    private String description;

}
