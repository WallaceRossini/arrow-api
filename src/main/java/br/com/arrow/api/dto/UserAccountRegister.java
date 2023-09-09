package br.com.arrow.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserAccountRegister {
    @NotBlank
    @Size(min = 5, max = 100)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 11, max = 12)
    private String phoneNumber;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

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
}
