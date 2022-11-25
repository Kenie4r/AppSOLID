package org.kodigo;

import org.kodigo.Class.AccessControl;
import org.kodigo.Menus.MenuLogin;

public class main {
    public static void main(String[] args) {
        MenuLogin menuLogin = new MenuLogin(new AccessControl());
        menuLogin.lanzarMenu();
    }
}
