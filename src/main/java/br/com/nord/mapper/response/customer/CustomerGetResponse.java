package br.com.nord.mapper.response.customer;

import br.com.nord.enums.PersonType;
import br.com.nord.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerGetResponse {

    private String fullName;

    private String cpfCnpj;

    private String email;

    private PersonType personType;

    private LocalDateTime bornDate;

    private Address address;

}
