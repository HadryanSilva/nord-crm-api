package br.com.nord.mapper.request.user;

import br.com.nord.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPutRequest {

    private Long id;

    private String username;

    private String password;

    private String email;

    private UserRole role;

}
