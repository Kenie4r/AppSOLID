package org.kodigo.Class;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MailTest {

    @Test
    @Disabled
    void mailTest(){
        Mail mail = new Mail(new Casa(0,"San Salvador","Mejicanos",0,
                new Person("0","Persona Prueba","alfredodiego42@hotmail.com"),0.0));
        String body = "<html>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "    <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" style=\"padding:0;\">\n" +
                "\t\t\t\tHello!\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</body>\n" +
                "</html>";
        mail.sendemail(body);
    }

}
