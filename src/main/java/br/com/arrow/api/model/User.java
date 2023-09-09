package br.com.arrow.api.model;

import br.com.arrow.api.dto.UserAccountRegister;
import br.com.arrow.api.enums.Role;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User () {

    }
    public User(Long id, String username, String email, String phoneNumber, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User(UserAccountRegister register) {
        this.username = register.getUsername();
        this.email = register.getEmail();
        this.phoneNumber = register.getPhoneNumber();
        this.password = encoderPassword(register.getPassword());
        this.role = Role.CLIENT;
    }

    public String encoderPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

