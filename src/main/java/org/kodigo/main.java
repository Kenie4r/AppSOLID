package org.kodigo;

import org.kodigo.Class.*;
import org.kodigo.Menus.MenuLogin;
import org.kodigo.Utils.MailCreator;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
            pruebaReporte();
            pruebaMail();
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
        Charge charge1 = new Charge();
        Charge charge2 = new Charge();
        List<Charge> listcharge = new ArrayList<>();
        listcharge.add(charge1);
        listcharge.add(charge2);
        Reporte reporte = new Reporte("Agua",2, "120",listcharge);
        reporte.GenerarReporte();
    }

    private static void pruebaMail(){
        MailCreator ma = new MailCreator();
        Servicio se = new Servicio();
        InvoiceElictricity ie = new InvoiceElictricity(se);
        Casa c = new Casa();
        ma.makeBodyForMail(ie,c);
    }
}
