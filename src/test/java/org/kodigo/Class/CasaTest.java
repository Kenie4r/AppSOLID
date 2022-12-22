package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasaTest {
    @Test
    void casaTest(){
        Casa casa = new Casa(0,"San Salvador","Mejicanos",0,new Person("0","Persona Prueba","mail@mail.com"),0.0);
        assertAll(()->{
            assertEquals(0,casa.getCodigoCasa());
            assertEquals(0,casa.getNumeroCasa());
            assertEquals("El Salvador",casa.getPais());
            assertEquals("Persona Prueba",casa.getPropietario().getPersonName());
            assertEquals("San Salvador",casa.getDepartamento());
            assertEquals("Mejicanos",casa.getMunicipio());
        });
    }

}
