package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    void personaTest(){
        Person persona = new Person("0","persona","mail@mail.com");
        assertAll(()->{
            assertEquals("0",persona.getPersonCode());
            assertEquals("persona",persona.getPersonName());
            assertEquals("mail@mail.com",persona.getMail());
        });
    }

    @Test
    void changePersonaTest(){
        Person persona = new Person("0","persona","mail@mail.com");
        persona.setMail("mail@anothermail.com");
        persona.setPersonName("cambio");
        persona.setPersonCode("1");
        assertAll(()->{
            assertEquals("1",persona.getPersonCode());
            assertEquals("cambio",persona.getPersonName());
            assertEquals("mail@anothermail.com",persona.getMail());
        });

    }
}
