package br.com.nord.mapper;

import br.com.nord.mapper.request.user.UserGetRequest;
import br.com.nord.mapper.request.user.UserPostRequest;
import br.com.nord.mapper.request.user.UserPutRequest;
import br.com.nord.mapper.response.user.UserGetResponse;
import br.com.nord.mapper.response.user.UserPostResponse;
import br.com.nord.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", expression = "java(br.com.nord.enums.UserRole.fromString(request.getRole()))")
    User postToUser(UserPostRequest request);

    User getToUser(UserGetRequest request);

    UserGetRequest userToGetRequest(User user);

    User putToUser(UserPutRequest request);

    UserGetResponse userToGetResponse(User user);

    UserPostResponse userToPostResponse(User user);

}
