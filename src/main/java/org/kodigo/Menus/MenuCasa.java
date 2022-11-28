package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Class.Person;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

import java.awt.*;

public class MenuCasa implements IMenu {

    private IMenu menuAnterior;
    private Casa casaSeleccionada;

    public MenuCasa(IMenu menuAnterior,Casa casaSeleccionada) {
        this.menuAnterior = menuAnterior;
        this.casaSeleccionada = casaSeleccionada;
    }

    @Override
    public void lanzarMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

    private void imprimirOpciones(){
        ScreenCleaner.cleanScreen();
        System.out.println("\n*****************************************");
        System.out.println("                 Casa Co. "+casaSeleccionada.getCodigoCasa());
        System.out.println("          Propietario:  "+casaSeleccionada.getPropietario().getPersonName());
        System.out.println("          Departamento: "+casaSeleccionada.getDepartamento());
        System.out.println("*******************************************");
        System.out.println("**         Seleccione una opcion         **");
        System.out.println("*******************************************\n");
        casaSeleccionada.listarPersonas();
        System.out.println("\n*********************************************");
        System.out.println("**                * Opciones *             **");
        System.out.println("**                ************             **");
        System.out.println("**                                         **");
        System.out.println("**           a - Agregar Persona           **");
        System.out.println("**    No. Persona - Seleccionar Persona    **");
        System.out.println("**           r - Reportes por Casa         **");
        System.out.println("**              s - Servicios              **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

    private void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                casaSeleccionada.addPersona();
                lanzarMenu();
                break;
            case "r":
                lanzarMenuReportesPorCasa();
                break;
            case "s":
                lanzarMenuServicios();
                break;
            case "m":
                regresarAMenuAnterior();
                break;
            case "salir":
                CierreGlobal.cerrarAplicacion();
                break;
            case "Salir":
                CierreGlobal.cerrarAplicacion();
                break;
            case "SALIR":
                CierreGlobal.cerrarAplicacion();
                break;
        }
        validarPersonaSeleccionada(opciones);
    }

    private void validarPersonaSeleccionada(String opcion){
        if(Validar.esNumero(opcion)){
            int index = Parseador.parsearAIndex(opcion);
            if(casaSeleccionada.sobrepasaIndexPersona(index)){
                personaSeleccionada(index);
            }
        }
        lanzarMenu();
    }

    private void personaSeleccionada(int index){
        mostrarOpcionesPersona();
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "e":
                casaSeleccionada.eliminarPersona(index);
                break;
            case "c":
                casaSeleccionada.cambiarPerson(index);
                break;
        }
    }

    private void mostrarOpcionesPersona(){
        System.out.println("\n*******************");
        System.out.println("**** Opciones ****");
        System.out.println("******************");
        System.out.println("** e - Eliminar **");
        System.out.println("** c - Cambiar  **");
        System.out.println("******************\n");
    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }

    private void lanzarMenuServicios(){
        MenuServicios menuServicios = new MenuServicios(this,this.casaSeleccionada);
        menuServicios.lanzarMenu();
    }

    private void lanzarMenuReportesPorCasa(){
        ScreenCleaner.cleanScreen();
        System.out.println("Opcion -Reportes de Todas Por Casa Individual");
    }
}
