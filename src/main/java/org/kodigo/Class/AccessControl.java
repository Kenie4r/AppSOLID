package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Class.DAL.UserDAL;
import org.kodigo.Interfaces.ILoginInterface;
import org.kodigo.Utils.Logger;

import java.util.Scanner;

public class AccessControl implements ILoginInterface {
    @Getter
    @Setter
    private static User loggedUser;

    private static boolean verifyLogin(User user) throws Exception{
        try{
            User userToLog = UserDAL.getUser(user.getUsername());
            return userToLog.equals(user);
        }catch(Exception ex){
            Logger.logError(ex.getMessage());
            throw ex;
        }
    }

    public static boolean register(User toRegister){
        try{
            UserDAL.addUser(toRegister);
            return true;
        }catch(Exception ex){
            Logger.logError(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean TryLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por Favor Ingrese el Usuario: ");
        String username = scanner.nextLine();
        System.out.println("Por favor Ingrese la Contraseña: ");
        String password = scanner.nextLine();

        User userToLog = new User(username, password);

        try{
            if (verifyLogin(userToLog)) {
                loggedUser = userToLog;
                return true;
            }
            return false;
        }catch(Exception ex){
            Logger.logError(ex.getMessage());
            return false;
        }
    }
}