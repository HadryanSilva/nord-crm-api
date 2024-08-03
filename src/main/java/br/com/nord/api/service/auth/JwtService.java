package br.com.nord.api.service.auth;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final JwtEncoder encoder;

    private final JwtDecoder decoder;

    public String generateToken(Authentication authentication) {
       var now = Instant.now();
       var expiration = now.plusSeconds(360);

       String scopes = authentication.getAuthorities().stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.joining(""));

       var claims = JwtClaimsSet.builder()
               .issuer("nord-crm-api")
               .subject(authentication.getName())
               .issuedAt(now)
               .expiresAt(expiration)
               .claim("scope", scopes)
               .build();

       return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public boolean validateToken(String token) {
        try {
            decoder.decode(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Jwt jwt = decoder.decode(token);
        return jwt.getSubject();
    }

}
