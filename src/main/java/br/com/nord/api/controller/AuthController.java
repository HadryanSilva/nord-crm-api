package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.user.UserPostRequest;
import br.com.nord.api.mapper.response.user.UserPostResponse;
import br.com.nord.api.service.UserService;
import br.com.nord.api.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(Authentication authentication) {
        return ResponseEntity.ok(jwtService.generateToken(authentication));
    }

    @PostMapping("/register")
    public ResponseEntity<UserPostResponse> save(@RequestBody UserPostRequest request) {
        var response = userService.save(request);
        return ResponseEntity
                .created(URI.create("/api/v1/users/" + response.getId()))
                .body(response);
    }

}
