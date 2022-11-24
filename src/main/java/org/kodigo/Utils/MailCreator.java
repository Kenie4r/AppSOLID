package org.kodigo.Utils;

import org.kodigo.Class.Invoice;
import org.kodigo.Interfaces.MailCreatorInterface;


public class MailCreator implements MailCreatorInterface {


//    A JAVA class that have the job to make a HTML body in order to have the classes more comfortable to edit in a future


    @Override
    public boolean makeBodyForMail(Invoice invoice) {


//    Just create the String data to the body
        String htmlBODY = "<html>" +
                "<body>" +
                "<h2>FACTURA DE SERVICIO</h2>" +
            "<p>Hola cliente, por este medio te compartimos las facturas de tu hogar," +
            " recuerda que puedes pagar estos servicios en las ventanillas del banco, etc. </p>" +
            invoice.toString()+
            "</body>" +
            "</html>";
//      Call the mail request function in order to send the email
        return makeRequestForMail(htmlBODY);
}

    @Override
    public boolean makeRequestForMail(String body) {
        //Llamar el objeto de mail para poder enviar el dato
        return false;
    }
}
