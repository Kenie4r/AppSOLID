package org.kodigo;

import org.kodigo.Class.*;
import org.kodigo.Menus.MenuLogin;
import org.kodigo.Utils.MailCreator;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        iniciarAplicacion();
    }

    private static void iniciarAplicacion(){
        MenuLogin menuLogin = new MenuLogin(new AccessControl());
        menuLogin.lanzarMenu();
    }
    private static void pruebasKenneth(){
        InvoiceElictricity elictricity = new InvoiceElictricity(new Servicio()) ;
        llamarInvoice(elictricity);
    }

    private static void llamarInvoice(Invoice invoice){
        System.out.println(invoice.toString());
    }

    private static  void pruebaReporte(){
        Invoice invoice = new Invoice(new Servicio());
        Reporte reporte = new Reporte(invoice.getService().getNombre(),2, String.valueOf(invoice.getTotal()), invoice.getCharges());
        reporte.GenerarReporte();
    }

    private static void pruebaMail(){
        MailCreator ma = new MailCreator();
        InvoiceElictricity ie = new InvoiceElictricity(new Servicio());
        Casa c = new Casa();
        ma.makeBodyForMail(ie,c);
    }
}
