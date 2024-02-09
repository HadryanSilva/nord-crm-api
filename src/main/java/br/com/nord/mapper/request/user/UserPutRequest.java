package br.com.nord.mapper.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPutRequest {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String role;

}
