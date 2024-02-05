package br.com.nord.nordcrmapi.mapper.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetRequest {

    private String username;
    private String email;

}
