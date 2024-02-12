package br.com.nord.controller;

import br.com.nord.mapper.record.LoginResponse;
import br.com.nord.mapper.request.user.UserLoginPostRequest;
import br.com.nord.model.User;
import br.com.nord.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginPostRequest request) {
        var authCredentials = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var auth = authenticationManager.authenticate(authCredentials);

        var token = jwtService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }

}
