package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;

public class MenuCasa implements IMenu {

    private IMenu menuAnterior;
    private Casa casaSeleccionada;

    public MenuCasa(Casa casaSeleccionada) {
        this.casaSeleccionada = casaSeleccionada;
    }

    @Override
    public void lanzarMenu() {

    }
}
