package Utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kodigo.Class.*;
import org.kodigo.Utils.MailCreator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MailCreatorTest {

    @Test
    @Disabled("Se queda Esperando por Input de Consola en Automatico")
    void testMakeBodyForMail(){
        MailCreator mail = new MailCreator();
        Date date = new Date();
        List<Charge> charges = new ArrayList<>();
        Person propietario = new Person("0","Prueba Correo","alfredodiego41@gmail.com");
        Invoice  invoice = new Invoice(date,0.0,new Servicio("Prueba De Correo","Prueba de Correo",0.00,date),charges);
        Casa casa = new Casa(0,"Prueba Correo","Prueba Correo",0, propietario,0.0);
        assertTrue(mail.makeBodyForMail(invoice,casa));
    }
}
