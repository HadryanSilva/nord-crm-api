package br.com.nord.mapper;

import br.com.nord.annotation.EncodedMapping;
import br.com.nord.mapper.request.user.UserGetRequest;
import br.com.nord.mapper.request.user.UserPostRequest;
import br.com.nord.mapper.request.user.UserPutRequest;
import br.com.nord.mapper.response.user.UserGetResponse;
import br.com.nord.mapper.response.user.UserPostResponse;
import br.com.nord.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User postToUser(UserPostRequest request);
    User getToUser(UserGetRequest request);

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User putToUser(UserPutRequest request);

    UserGetRequest userToGetRequest(User user);

    UserGetResponse userToGetResponse(User user);

    UserPostResponse userToPostResponse(User user);

    List<UserGetResponse> userToGetResponseList(List<User> users);

}
