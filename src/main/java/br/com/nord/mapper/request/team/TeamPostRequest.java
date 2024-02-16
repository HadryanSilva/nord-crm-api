package br.com.nord.mapper.request.team;

import br.com.nord.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamPostRequest {

    private String name;

    private List<User> members;

}
