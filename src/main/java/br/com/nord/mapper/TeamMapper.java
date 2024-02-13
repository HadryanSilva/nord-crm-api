package br.com.nord.mapper;

import br.com.nord.mapper.request.team.TeamPostRequest;
import br.com.nord.mapper.request.team.TeamPutRequest;
import br.com.nord.mapper.response.team.TeamGetResponse;
import br.com.nord.mapper.response.team.TeamPostResponse;
import br.com.nord.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {

    Team postToTeam(TeamPostRequest request);
    TeamPostResponse teamToPostResponse(Team team);
    TeamGetResponse teamToGetResponse(Team team);
    Team putToTeam(TeamPutRequest request);

}
