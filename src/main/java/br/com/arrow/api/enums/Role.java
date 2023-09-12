package br.com.arrow.api.enums;

public enum Role {
    ADMIN,
    CLIENT;

    public String getAuthority(){
        return name();
    }

}
