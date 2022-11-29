package org.kodigo.Menus;

import org.kodigo.Class.Charge;
import org.kodigo.Class.Invoice;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuCargos implements IMenu{
    private IMenu menuAnterior;

    private Invoice factura;

    public MenuCargos(IMenu menuAnterior,Invoice factura) {
        this.menuAnterior = menuAnterior;
        this.factura = factura;
    }

    @Override
    public void lanzarMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

    private void imprimirOpciones(){
        ScreenCleaner.cleanScreen();
        System.out.println("\n*******************************************");
        System.out.println("**            Cargos             **");
        System.out.println("*******************************************");
        System.out.println("            Servicio: "+factura.getService().getNombre());
        System.out.println("        Fecha Creada: ");
        System.out.println("    "+factura.getDataOfCreate());
        System.out.println("*******************************************");
        System.out.println("**         Seleccione una opcion         **");
        System.out.println("*******************************************\n");
        factura.listarCargos();
        System.out.println("\n*********************************************");
        System.out.println("**                * Opciones *             **");
        System.out.println("**                ************             **");
        System.out.println("**                                         **");
        System.out.println("**           a - Agregar Cargo             **");
        System.out.println("**      No. Cargo - Seleccionar Cargo      **");
       // System.out.println("**         r - Reportes por Cargo          **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

    private void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                ScreenCleaner.cleanScreen();
                factura.setNewChargeInInvoice(new Charge());
                lanzarMenu();
                break;
            case "r":
                lanzarMenuReportesPorCargo();
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
        validarCargoSeleccionado(opciones);
    }

    private void validarCargoSeleccionado(String opcion) {
        if(Validar.esNumero(opcion)){
            int index = Parseador.parsearAIndex(opcion);
            if(factura.sobrepasaIndexServicio(index)){
                cargoSeleccionado(index);
            }
        }
        lanzarMenu();
    }

    private void cargoSeleccionado(int index) {
        mostrarOpcionesCargo();
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "e":
                factura.eliminarCargo(index);
                break;
        }
    }

    private void lanzarMenuReportesPorCargo() {
        System.out.println("R - Reportes por Servicio");
    }


    private void mostrarOpcionesCargo(){
        System.out.println("\n**********************");
        System.out.println("***** Opciones  ******");
        System.out.println("**********************");
        System.out.println("**   e  - Eliminar  **");
        System.out.println("** Otro - Cancelar  **");
        System.out.println("**********************\n");
    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }
}
