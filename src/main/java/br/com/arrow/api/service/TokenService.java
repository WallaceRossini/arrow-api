package br.com.arrow.api.service;

import br.com.arrow.api.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user){
        try {
            Algorithm algerithm  = Algorithm.HMAC256("123456789");
            return JWT.create()
                    .withIssuer("API Arrow")
                    .withSubject(user.getUsername())
                    .withExpiresAt(dateExpires())
                    .withClaim("id", user.getId())
                    .sign(algerithm);
        }catch (JWTCreationException exception){
                throw new RuntimeException("Erro ao gerar JWT", exception);
        }
    }

    private Instant dateExpires(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
