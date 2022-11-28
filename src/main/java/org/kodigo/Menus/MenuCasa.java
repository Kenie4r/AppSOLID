package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Class.Person;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.PauseScreen;

public class MenuCasa implements IMenu {

    private IMenu menuAnterior;
    private Casa casaSeleccionada;

    public MenuCasa(IMenu menuAnterior,Casa casaSeleccionada) {
        this.menuAnterior = menuAnterior;
        this.casaSeleccionada = casaSeleccionada;
    }

    @Override
    public void lanzarMenu() {
        System.out.println("Menu Casas");
        System.out.println("Propietario: "+casaSeleccionada.getPropietario().getPersonName());
        System.out.println("Departamento: "+ casaSeleccionada.getDepartamento());
        System.out.println("---------------------------");
        PauseScreen.pause(10);
        casaSeleccionada.setPropietario(new Person("test","Juancho Panzas","test@panz.as"));

    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }
}
