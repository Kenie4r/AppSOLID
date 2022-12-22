package org.kodigo.Menus;

import org.kodigo.Interfaces.IMenu;

public abstract class MenuConcatenado implements IMenu {

    IMenu menuAnterior;

    public void lanzarSiguienteMenu(IMenu siguienteMenu){
        siguienteMenu.lanzarEsteMenu();
    }

    public void regresarAMenuAnterior(){
        menuAnterior.lanzarEsteMenu();
    }

}
