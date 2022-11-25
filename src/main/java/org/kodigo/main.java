package org.kodigo;

import org.kodigo.Class.Invoice;
import org.kodigo.Class.InvoiceElictricity;
import org.kodigo.Class.Servicio;

public class main {
    public static void main(String[] args) {

        InvoiceElictricity elictricity = new InvoiceElictricity(new Servicio()) ;
        llamarInvoice(elictricity);
    }


    public static void llamarInvoice(Invoice invoice){
        System.out.println(invoice.toString());
    }
}
