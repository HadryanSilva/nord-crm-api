package br.com.nord.nordcrmapi.controller;

import br.com.nord.nordcrmapi.mapper.UserMapper;
import br.com.nord.nordcrmapi.mapper.request.UserGetRequest;
import br.com.nord.nordcrmapi.mapper.request.UserPostRequest;
import br.com.nord.nordcrmapi.mapper.response.UserGetResponse;
import br.com.nord.nordcrmapi.mapper.response.UserPostResponse;
import br.com.nord.nordcrmapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/v1/user", "/api/v1/user/"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> findUserById(@PathVariable Long id) {
        var userFound = userService.findById(id);
        var convertedUser = mapper.userToGetResponse(userFound);
        return ResponseEntity.ok(convertedUser);
    }

    @PostMapping
    public ResponseEntity<UserPostResponse> saveUser(@RequestBody UserPostRequest request) {
        var userSaved = userService.save(request);
        var convertedUser = mapper.userToPostResponse(userSaved);
        return ResponseEntity.ok(convertedUser);
    }

    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
