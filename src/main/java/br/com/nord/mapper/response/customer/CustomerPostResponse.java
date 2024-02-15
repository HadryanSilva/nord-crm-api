package br.com.nord.mapper.response.customer;

import br.com.nord.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPostResponse {

    private Long id;

    private String fullName;

    private String cpfCnpj;

    private String email;

    private String phone;

    private String personType;

    private Address address;

}
