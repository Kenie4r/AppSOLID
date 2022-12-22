package org.kodigo;

import org.kodigo.Class.AccessControl;
import org.kodigo.Class.Invoice;
import org.kodigo.Class.InvoiceElictricity;
import org.kodigo.Class.Servicio;
import org.kodigo.Menus.MenuLogin;

public class main {
    public static void main(String[] args) {
        iniciarAplicacion();
    }

    private static void iniciarAplicacion(){
        MenuLogin menuLogin = new MenuLogin(new AccessControl());
        menuLogin.lanzarEsteMenu();
    }
    private static void pruebasKenneth(){
        InvoiceElictricity elictricity = new InvoiceElictricity(new Servicio()) ;
        llamarInvoice(elictricity);
    }

    private static void llamarInvoice(Invoice invoice){
        System.out.println(invoice.toString());
    }
}
