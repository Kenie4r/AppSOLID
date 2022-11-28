package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuFacturas implements IMenu {

    private IMenu menuAnterior;

    private Casa casaSeleccionada;

    public MenuFacturas(IMenu menuAnterior,Casa casaSeleccionada) {
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
        System.out.println("\n*******************************************");
        System.out.println("**            Menu Servicios             **");
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
        System.out.println("**          r - Reportes por Servicio      **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

    private void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                ScreenCleaner.cleanScreen();
                casaSeleccionada.addServicio();
                lanzarMenu();
                break;
            case "r":
                lanzarMenuReportesPorServicio();
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
        validarServicioSeleccionado(opciones);
    }

    private void validarServicioSeleccionado(String opcion) {
        if(Validar.esNumero(opcion)){
            int index = Parseador.parsearAIndex(opcion);
            if(casaSeleccionada.sobrepasaIndexServicio(index)){
                servicioSeleccionado(index);
            }
        }
        lanzarMenu();
    }

    private void servicioSeleccionado(int index) {
        mostrarOpcionesServicio();
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "s":

                break;
            case "e":
                casaSeleccionada.eliminarServicio(index);
                break;
        }
    }

    private void lanzarMenuReportesPorServicio() {
        System.out.println("R - Reportes por Servicio");
    }

    private void lanzarMenuFacturas(){
        ScreenCleaner.cleanScreen();
        MenuFacturas menuFacturas  = new MenuFacturas(this,this.casaSeleccionada);
        menuFacturas.lanzarMenu();
    }

    private void mostrarOpcionesServicio(){
        System.out.println("\n**********************");
        System.out.println("***** Opciones  ******");
        System.out.println("**********************");
        System.out.println("**  s - Seleccionar **");
        System.out.println("**  e - Eliminar    **");
        System.out.println("**********************\n");
    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }
}
