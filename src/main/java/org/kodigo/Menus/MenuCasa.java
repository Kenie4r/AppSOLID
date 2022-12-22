package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuCasa extends MenuSubOpciones {

    private Casa casaSeleccionada;

    public MenuCasa(IMenu menuAnterior,Casa casaSeleccionada) {
        this.menuAnterior = menuAnterior;
        this.casaSeleccionada = casaSeleccionada;
    }

    @Override
    public void lanzarEsteMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

     void imprimirOpciones(){
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
        //System.out.println("**           r - Reportes por Casa         **");
        System.out.println("**              s - Servicios              **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

     void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                casaSeleccionada.addPersona();
                lanzarEsteMenu();
                break;
            case "s":
                lanzarSiguienteMenu(new MenuServicios(this,this.casaSeleccionada));
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
        validarOpcion(opciones);
    }

    @Override
    void validarOpcion(String opcion) {
        if(Validar.esNumero(opcion)){
            int index = Parseador.parsearAIndex(opcion);
            if(casaSeleccionada.sobrepasaIndexPersona(index)){
                opcionSeleccionanda(index);
            }
        }
        lanzarEsteMenu();
    }

    @Override
    void opcionSeleccionanda(int index) {
        mostrarSubOpciones();
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

    @Override
    void mostrarSubOpciones() {
        System.out.println("\n*******************");
        System.out.println("**** Opciones ****");
        System.out.println("******************");
        System.out.println("** e - Eliminar **");
        System.out.println("** c - Cambiar  **");
        System.out.println("******************\n");
    }
}
