package br.com.nord.mapper.response.customer;

import br.com.nord.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerGetResponse {

    private Long id;

    private String fullName;

    private String phone;

    private PersonType personType;

}
