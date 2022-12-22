package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Class.InvoiceElictricity;
import org.kodigo.Class.Reporte;
import org.kodigo.Class.Servicio;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

public class MenuFacturas implements IMenu {

    private IMenu menuAnterior;

    private Casa casaSeleccionada;

    private int servicioEnUso;

    public MenuFacturas(IMenu menuAnterior, Casa casaSeleccionada, int index) {
        this.menuAnterior = menuAnterior;
        this.casaSeleccionada = casaSeleccionada;
        this.servicioEnUso = index;
    }

    @Override
    public void lanzarMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

    private void imprimirOpciones() {
        ScreenCleaner.cleanScreen();
        System.out.println("\n*******************************************");
        System.out.println("**                Facturas               **");
        System.out.println("*******************************************");
        System.out.println("           Servicio: " + casaSeleccionada.getServicio(servicioEnUso).getNombre());
        System.out.println("          Proveedor: " + casaSeleccionada.getServicio(servicioEnUso).getProveedor());
        System.out.println("*******************************************");
        System.out.println("**         Seleccione una opcion         **");
        System.out.println("*******************************************\n");
        casaSeleccionada.getServicio(servicioEnUso).listarFacturas();
        System.out.println("\n*********************************************");
        System.out.println("**                * Opciones *             **");
        System.out.println("**                ************             **");
        System.out.println("**                                         **");
        System.out.println("**          a - Agregar Factura            **");
        System.out.println("**    No. Factura - Seleccionar Factura    **");
        //System.out.println("**          r - Reportes por Factura       **");
        System.out.println("**      s - Enviar Facturas por Correo     **");
        System.out.println("**             m - Menu Anterior           **");
        System.out.println("**       salir - Finalizar aplicacion      **");
        System.out.println("*********************************************\n");
    }

    private void tomarOpcion() {
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones) {
            case "a":
                ScreenCleaner.cleanScreen();
                casaSeleccionada.getServicio(servicioEnUso).añadirFactura();
                lanzarMenu();
                break;
            case "r":
                lanzarMenuReportesPorFactura();
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
        validarFacturaSeleccionada(opciones);
    }

    private void validarFacturaSeleccionada(String opcion) {
        if (Validar.esNumero(opcion)) {
            int index = Parseador.parsearAIndex(opcion);
            if (casaSeleccionada.getServicio(servicioEnUso).sobrepasaIndexFactura(index)) {
                facturaElegida(index);
            }
        }
        lanzarMenu();
    }

    private void facturaElegida(int index) {
        mostrarOpcionesFactura();
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones) {
            case "v":
                verFactura(index);
                break;
            case "g":
                generarReporte(index);
                break;
            case "c":
                lanzarMenuCargos(index);
                break;
            case "m":
                enviarFacturaPorCorreo(index);
                break;
            case "e":
                casaSeleccionada.getServicio(servicioEnUso).eliminarFactura(index);
                break;
        }
    }

    private void lanzarMenuReportesPorFactura() {
        System.out.println("R - Reportes por Factura");
    }

    private void lanzarMenuCargos(int index) {
        ScreenCleaner.cleanScreen();
        MenuCargos menuFacturas = new MenuCargos(this, casaSeleccionada.getServicio(servicioEnUso).getFactura(index));
        menuFacturas.lanzarMenu();
    }

    private void mostrarOpcionesFactura() {
        System.out.println("\n**************************");
        System.out.println("****** Opciones  **********");
        System.out.println("***************************");
        System.out.println("**  v - Ver factura      **");
        System.out.println("**  c - Ver cargos       **");
        System.out.println("**  g - Generar Reporte  **");
        System.out.println("**  m - Enviar Correo    **");
        System.out.println("**  e - Eliminar         **");
        System.out.println("***************************\n");
    }

    private void verFactura(int index) {
        System.out.println(casaSeleccionada.getServicio(servicioEnUso).getFactura(index).toString());
        System.out.println("\n <<Continuar>> \n");
        ConsoleScanner.getString();
    }

    private void enviarFacturaPorCorreo(int index){
        MailCreator ma = new MailCreator();
        ma.makeBodyForMail(casaSeleccionada.getServicio(servicioEnUso).getFactura(index),casaSeleccionada);
    }

    private void generarReporte(int index){
        Reporte reporte = new Reporte(casaSeleccionada.getServicio(servicioEnUso).getFactura(index));
        reporte.GenerarReporte();
        ConsoleScanner.getString();
    }

    private void regresarAMenuAnterior(){
        this.menuAnterior.lanzarMenu();
    }
}
