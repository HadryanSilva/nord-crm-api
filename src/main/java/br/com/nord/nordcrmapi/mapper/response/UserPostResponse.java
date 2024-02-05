package br.com.nord.nordcrmapi.mapper.response;

import br.com.nord.nordcrmapi.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostResponse {

    private Long id;
    private String username;
    private String email;
    private UserRole role;
}
