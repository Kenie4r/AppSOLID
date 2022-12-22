package org.kodigo.Menus;

import org.kodigo.Class.Charge;
import org.kodigo.Class.Invoice;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuCargos extends MenuSubOpciones{
    private Invoice factura;

    public MenuCargos(IMenu menuAnterior,Invoice factura) {
        this.menuAnterior = menuAnterior;
        this.factura = factura;
    }

    @Override
    public void lanzarEsteMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

    public void imprimirOpciones(){
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

    public void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                ScreenCleaner.cleanScreen();
                factura.setNewChargeInInvoice(new Charge());
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
            if(factura.sobrepasaIndexServicio(index)){
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
                factura.eliminarCargo(index);
                break;
        }
    }



    @Override
    void mostrarSubOpciones() {
        System.out.println("\n**********************");
        System.out.println("***** Opciones  ******");
        System.out.println("**********************");
        System.out.println("**   e  - Eliminar  **");
        System.out.println("** Otro - Cancelar  **");
        System.out.println("**********************\n");
    }
}
