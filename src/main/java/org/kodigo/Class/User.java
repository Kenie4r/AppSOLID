package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
public class User {

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String email;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.email = null;

    }

}