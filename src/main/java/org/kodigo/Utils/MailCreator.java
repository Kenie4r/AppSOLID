package org.kodigo.Utils;

import org.kodigo.Class.Casa;
import org.kodigo.Class.Invoice;
import org.kodigo.Class.Mail;
import org.kodigo.Class.Person;
import org.kodigo.Interfaces.MailCreatorInterface;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailCreator implements MailCreatorInterface {


//    A JAVA class that have the job to make a HTML body in order to have the classes more comfortable to edit in a future


    @Override
    public boolean makeBodyForMail(Invoice invoice, Casa casa) {


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
        return makeRequestForMail(htmlBODY, casa);
}

    @Override
    public boolean makeRequestForMail(String body,  Casa c) {
        Mail mail = new Mail(c);
        mail.sendemail(body);
        return false;
    }
}



