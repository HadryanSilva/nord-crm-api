package br.com.nord.api.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final JwtEncoder encoder;

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

}
