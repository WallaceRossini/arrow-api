package br.com.arrow.api.resource;

import br.com.arrow.api.dto.UserAccountCredential;
import br.com.arrow.api.dto.UserAccountRegister;
import br.com.arrow.api.model.User;
import br.com.arrow.api.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserAuthentication {
    @Autowired
    private UserService service;

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody UserAccountCredential credential){
        ResponseEntity<String> user = service.signIn(credential);
        return user;
    }

    @PostMapping("/signUp")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(@RequestBody @Valid UserAccountRegister register){
        User user = service.signUp(register);
        return user;
    }
}
