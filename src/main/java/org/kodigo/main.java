package org.kodigo;


import org.kodigo.Class.AccessControl;
import org.kodigo.Class.DAL.UserDAL;

public class main {

    public static void main(String[] args){
        boolean success = AccessControl.login();
        System.out.println(success);
    }

}
