package br.com.nord.mapper.response.team;

import br.com.nord.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamPostResponse {

    private Long id;
    private String name;
    private List<User> members;

}
