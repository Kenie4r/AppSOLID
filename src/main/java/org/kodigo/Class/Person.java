package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodigo.Utils.ConsoleScanner;

/*
Persona va a pedir sus propios Datos? o se piden por el MenuPrincipal.
* */
@AllArgsConstructor
public class Person {
    @Getter
    @Setter
    private String personCode;
    @Getter
    @Setter
    private String personName;
    @Getter
    @Setter
    private String mail;

    Person(){
        System.out.println("***************************");
        System.out.println("     Añadiendo Persona:    ");
        System.out.println("***************************\n");
        System.out.println("Por favor Ingrese el Codigo Persona:");
        this.personCode = ConsoleScanner.getSingleString();
        System.out.println("Por favor Ingrese el Nombre de la Persona:");
        this.personName = ConsoleScanner.getString();
        System.out.println("Por favor Ingrese un Correo Electronico:");
        this.mail = ConsoleScanner.getSingleString();
    }
}
