package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuServicios extends MenuSubOpciones {

    private Casa casaSeleccionada;

    public MenuServicios(IMenu menuAnterior,Casa casaSeleccionada) {
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
        System.out.println("\n*******************************************");
        System.out.println("**               Servicios               **");
        System.out.println("*******************************************");
        System.out.println("                 Casa Co. "+casaSeleccionada.getCodigoCasa());
        System.out.println("          Propietario:  "+casaSeleccionada.getPropietario().getPersonName());
        System.out.println("          Departamento: "+casaSeleccionada.getDepartamento());
        System.out.println("*******************************************");
        System.out.println("**         Seleccione una opcion         **");
        System.out.println("*******************************************\n");
        casaSeleccionada.listarServicios();
        System.out.println("\n*********************************************");
        System.out.println("**                * Opciones *             **");
        System.out.println("**                ************             **");
        System.out.println("**                                         **");
        System.out.println("**          a - Agregar Servicio           **");
        System.out.println("**   No. Servicio - Seleccionar Servicio   **");
        //System.out.println("**          r - Reportes por Servicio      **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

    void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                ScreenCleaner.cleanScreen();
                casaSeleccionada.addServicio();
                lanzarEsteMenu();
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
            if(casaSeleccionada.sobrepasaIndexServicio(index)){
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
            case "s":
                ScreenCleaner.cleanScreen();
                lanzarSiguienteMenu(new MenuFacturas(this,this.casaSeleccionada,index));
                break;
            case "e":
                casaSeleccionada.eliminarServicio(index);
                break;
        }
    }


    @Override
    void mostrarSubOpciones() {
        System.out.println("\n**********************");
        System.out.println("***** Opciones  ******");
        System.out.println("**********************");
        System.out.println("**  s - Seleccionar **");
        System.out.println("**  e - Eliminar    **");
        System.out.println("**********************\n");
    }
}
