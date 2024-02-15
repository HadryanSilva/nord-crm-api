package br.com.nord.mapper.request.customer;

import br.com.nord.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPutRequest {

    @NotBlank(message = "Id cannot be empty")
    private Long id;

    @NotBlank(message = "Full Name cannot be empty")
    private String fullName;

    @NotBlank(message = "CPF/CNPJ cannot be empty")
    private String cpfCnpj;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email")
    private String email;

    @Pattern(regexp = "^\\s*(\\d{2}|\\d{0})[-. ]?(\\d{5}|\\d{4})[-. ]?(\\d{4})[-. ]?\\s*$", message = "Invalid phone")
    private String phone;

    @NotBlank(message = "Person Type cannot be empty")
    private String personType;

    private Address address;

}
