package br.com.nord.controller;

import br.com.nord.mapper.UserMapper;
import br.com.nord.mapper.request.user.UserPostRequest;
import br.com.nord.mapper.request.user.UserPutRequest;
import br.com.nord.mapper.response.user.UserGetResponse;
import br.com.nord.mapper.response.user.UserPostResponse;
import br.com.nord.service.auth.JwtService;
import br.com.nord.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/v1/user", "/api/v1/user/"})
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;
    private final JwtService jwtService;

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> findById(@PathVariable Long id) {
        var userFound = userService.findById(id);
        var userConverted = mapper.userToGetResponse(userFound);
        return ResponseEntity.ok(userConverted);
    }

    @PostMapping
    public ResponseEntity<UserPostResponse> create(@RequestBody @Valid UserPostRequest request) {
        var userToSave = mapper.postToUser(request);
        var userSaved = userService.save(userToSave);
        var userConverted = mapper.userToPostResponse(userSaved);
        return ResponseEntity.status(201).body(userConverted);
    }

    @DeleteMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserPutRequest request) {
        var userToUpdate = mapper.putToUser(request);
        userService.update(userToUpdate);
        var newToken = jwtService.generateToken(userToUpdate);
        log.info("The credentias are updated, a new JWT token has been generated.");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + newToken);
        return ResponseEntity.noContent().headers(headers).build();
    }

}
