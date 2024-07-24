package br.com.nord.api.mapper.response.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetResponse {

    private String username;
    private String email;
    private String password;

}
