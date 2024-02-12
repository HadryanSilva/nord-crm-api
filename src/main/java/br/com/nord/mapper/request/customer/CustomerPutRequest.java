package br.com.nord.mapper.request.customer;

import br.com.nord.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @NotBlank(message = "Person Type cannot be empty")
    private String personType;

    @NotBlank(message = "Born Date cannot be empty")
    private LocalDateTime bornDate;

    private Address address;

}
