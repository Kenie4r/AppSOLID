package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Class.DAL.UserDAL;

import java.util.Scanner;

public class AccessControl {
    @Getter
    @Setter
    private static User loggedUser;

    private static boolean verifyLogin(User user){
        User userToLog = UserDAL.getUser(user.getUsername());
        return userToLog != null && userToLog.getPassword().equals(user.getPassword());
    }


    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        User userToLog = new User(username, password);

        if (verifyLogin(userToLog)){
            loggedUser = userToLog;
            return true;
        }
        return false;

    }
}