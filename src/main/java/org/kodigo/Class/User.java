package org.kodigo.Class;

import lombok.Setter;
import lombok.Getter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
