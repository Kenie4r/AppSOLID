package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioTest {
    @Test
    void servicioTest(){
        Date date = new Date(2022-1900, Calendar.DECEMBER,01);
        Servicio servicio = new Servicio("Servicio de Prueba","Pruebas",1.0,date);
        assertEquals(33,servicio.diasDeServicioActivo());
    }
}
