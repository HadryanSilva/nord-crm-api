package br.com.nord.api.mapper.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {

    private String username;
    private String email;
    private String password;

}
