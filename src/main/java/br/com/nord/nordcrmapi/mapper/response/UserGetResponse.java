package br.com.nord.nordcrmapi.mapper.response;

import br.com.nord.nordcrmapi.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetResponse {

    private String username;
    private String email;
    private String role;

}
