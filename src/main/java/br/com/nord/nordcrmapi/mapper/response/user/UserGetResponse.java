package br.com.nord.nordcrmapi.mapper.response.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetResponse {

    private String username;
    private String email;
    private String role;

}
