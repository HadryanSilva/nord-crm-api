package br.com.nord.mapper.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginPostRequest {

    private String username;
    private String password;

}
