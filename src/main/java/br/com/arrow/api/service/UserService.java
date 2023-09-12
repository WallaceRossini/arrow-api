package br.com.arrow.api.service;

import br.com.arrow.api.dto.UserAccountCredential;
import br.com.arrow.api.dto.UserAccountRegister;
import br.com.arrow.api.model.User;
import br.com.arrow.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    public User signUp(UserAccountRegister register) {
        return repository.save(new User(register));
    }

    public ResponseEntity<String> signIn(UserAccountCredential credential) {
        try {
            UsernamePasswordAuthenticationToken user =
                    new UsernamePasswordAuthenticationToken(
                            credential.getEmail(),
                            credential.getPassword()
                    );

           Authentication authentication = manager.authenticate(user);

           String token = tokenService.generateToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
