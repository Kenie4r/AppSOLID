package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Class.DAL.UserDAL;

import java.util.Scanner;

public class AccessControl {
    @Getter
    @Setter
    private static User loggedUser;

    private static boolean verifyLogin(User user) throws Exception{
        try{
            User userToLog = UserDAL.getUser(user.getUsername());
            return userToLog.equals(user);
        }catch(Exception ex){
            throw ex;
        }
    }


    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        User userToLog = new User(username, password);

        try{
            if (verifyLogin(userToLog)) {
                loggedUser = userToLog;
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }

    }


    public static boolean register(User toRegister){
        try{
            UserDAL.addUser(toRegister);
            return true;
        }catch(Exception ex){
            return false;
        }

    }
}