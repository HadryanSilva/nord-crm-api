package br.com.nord.api.mapper;

import br.com.nord.api.mapper.request.user.UserPostRequest;
import br.com.nord.api.mapper.response.user.UserGetResponse;
import br.com.nord.api.mapper.response.user.UserPostResponse;
import br.com.nord.api.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User postToUser(UserPostRequest userPostRequest);

    UserGetResponse userToGetResponse(User user);

    UserPostResponse userToPostResponse(User user);

}
