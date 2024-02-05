package br.com.nord.mapper.response.user;

import br.com.nord.enums.UserRole;
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
