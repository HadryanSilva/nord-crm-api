package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.auth.RefreshTokenRequest;
import br.com.nord.api.mapper.request.user.UserPostRequest;
import br.com.nord.api.mapper.response.auth.RefreshTokenResponse;
import br.com.nord.api.mapper.response.user.UserPostResponse;
import br.com.nord.api.service.UserService;
import br.com.nord.api.service.auth.JwtService;
import br.com.nord.api.service.auth.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;

    private final UserDetailsServiceImpl userDetailsService;

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

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
        if (jwtService.validateToken(request.token())) {
            String username = jwtService.getUsernameFromToken(request.token());
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());

            String newAccessToken = jwtService.generateToken(authentication);
            return ResponseEntity.ok(new RefreshTokenResponse(newAccessToken));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
    }

}
