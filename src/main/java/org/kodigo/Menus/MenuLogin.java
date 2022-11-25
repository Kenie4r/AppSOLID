package org.kodigo.Menus;

import org.kodigo.Interfaces.ILoginInterface;
import org.kodigo.Interfaces.IMenu;

import java.awt.*;

public class MenuLogin implements IMenu{

    ILoginInterface accessControl;
    IMenu siguienteMenu;

    public MenuLogin(ILoginInterface accessControl) {
        this.accessControl = accessControl;
    }

    private void mostrarLogin(){
        Boolean loginExitoso = false;
        do{
            System.out.println("Por favor Intente Iniciar Sesion:");
            loginExitoso =accessControl.TryLogin();
        }while (!loginExitoso);
    }

    private void mostrarBienvenida(){
        System.out.println("Gracias por Usar Nuestro Programa");
    }

    @Override
    public void lanzarMenu() {
        mostrarBienvenida();
        mostrarLogin();
        siguienteMenu.lanzarMenu();
    }
}
