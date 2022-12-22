package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargeTest {

    @Test
    void chargeTest(){
        Charge charge = new Charge("Cargo de Prueba",1.0);
        assertAll(()->{
            assertEquals("Cargo de Prueba",charge.getName());
            assertEquals(1.0,charge.getPrice());
        });
    }

    @Test
    void chargeChangeTest(){
        Charge charge = new Charge("Cargo de Prueba",1.0);
        charge.setName("Cargo Cambiado");
        charge.setPrice(2.0);
        assertAll(()->{
            assertEquals("Cargo Cambiado",charge.getName());
            assertEquals(2.0,charge.getPrice());
        });

    }
}
