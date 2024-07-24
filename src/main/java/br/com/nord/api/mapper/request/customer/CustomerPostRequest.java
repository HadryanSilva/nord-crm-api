package br.com.nord.api.mapper.request.customer;

import br.com.nord.api.model.Address;
import br.com.nord.api.model.enums.PersonType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CustomerPostRequest {

    private String fullName;

    private String cpf_cnpj;

    private String email;

    private PersonType personType;

    private LocalDate bornDate;

    private Address address;

}
