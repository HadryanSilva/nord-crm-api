package br.com.nord.nordcrmapi.controller;

import br.com.nord.nordcrmapi.mapper.UserMapper;
import br.com.nord.nordcrmapi.mapper.request.user.UserPostRequest;
import br.com.nord.nordcrmapi.mapper.request.user.UserPutRequest;
import br.com.nord.nordcrmapi.mapper.response.user.UserGetResponse;
import br.com.nord.nordcrmapi.mapper.response.user.UserPostResponse;
import br.com.nord.nordcrmapi.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserGetResponse> findById(@PathVariable Long id) {
        var userFound = userService.findById(id);
        var userConverted = mapper.userToGetResponse(userFound);
        return ResponseEntity.ok(userConverted);
    }

    @PostMapping
    public ResponseEntity<UserPostResponse> save(@RequestBody @Valid UserPostRequest request) {
        var userSaved = userService.save(request);
        var userConverted = mapper.userToPostResponse(userSaved);
        return ResponseEntity.status(201).body(userConverted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserPutRequest request) {
        userService.update(request);
        return ResponseEntity.noContent().build();
    }

}
