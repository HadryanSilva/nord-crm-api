package br.com.nord.api.mapper.response.customer;

import br.com.nord.api.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPostResponse {

    private Long id;

    private String fullName;

    private String cpf_cnpj;

    private String email;

    private String personType;

    private String bornDate;

    private Address address;

}
