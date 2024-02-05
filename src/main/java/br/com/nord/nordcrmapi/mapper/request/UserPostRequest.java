package br.com.nord.nordcrmapi.mapper.request;

import br.com.nord.nordcrmapi.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {

    private String username;

    private String password;

    private String email;

    private String role;

}
