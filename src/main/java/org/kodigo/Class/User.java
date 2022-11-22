package org.kodigo.Class;

import lombok.Setter;
import lombok.Getter;

public class User {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }




}
