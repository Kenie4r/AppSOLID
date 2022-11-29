package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword());
    }

    @Override
    public String toString() {
        return "{\"username\":\"" + this.username +
                "\",\"password\": \"" + this.password +
                "\",\"email\": \"" + this.email + "\"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}