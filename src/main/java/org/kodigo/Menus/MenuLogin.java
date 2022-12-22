package org.kodigo.Menus;

import org.kodigo.Interfaces.ILoginInterface;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.ScreenCleaner;

public class MenuLogin implements IMenu{

    ILoginInterface accessControl;
    IMenu siguienteMenu;

    public MenuLogin(ILoginInterface accessControl){
        this.accessControl = accessControl;
        this.siguienteMenu = new MenuPrincipal();
    }
    public MenuLogin(ILoginInterface accessControl, IMenu siguienteMenu) {
        this.accessControl = accessControl;
        this.siguienteMenu = siguienteMenu;
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
    public void lanzarEsteMenu() {
        mostrarBienvenida();
        mostrarLogin();
        ScreenCleaner.cleanScreen();
        siguienteMenu.lanzarEsteMenu();
    }
}
