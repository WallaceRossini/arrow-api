package br.com.arrow.api.service;

import br.com.arrow.api.dto.UserAccountRegister;
import br.com.arrow.api.model.User;
import br.com.arrow.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User signUp(UserAccountRegister register){
        return repository.save(new User(register));
    }
}
