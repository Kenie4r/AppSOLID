package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Class.Servicio;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.CierreGlobal;
import org.kodigo.Utils.ConsoleScanner;
import org.kodigo.Utils.ScreenCleaner;

public class MenuServicios implements IMenu {

    private IMenu menuAnterior;

    private Casa casaSeleccionada;

    public MenuServicios(IMenu menuAnterior,Casa casaSeleccionada) {
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

    private void validarServicioSeleccionado(String opciones) {
        
    }

    private void lanzarMenuReportesPorServicio() {
    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }
}
