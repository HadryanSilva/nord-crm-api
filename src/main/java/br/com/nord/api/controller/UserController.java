package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.user.UserPostRequest;
import br.com.nord.api.mapper.response.user.UserGetResponse;
import br.com.nord.api.mapper.response.user.UserPostResponse;
import br.com.nord.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                         @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.findAll(page, size));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, UserPostRequest request) {
        userService.update(id, request);
    }

}
