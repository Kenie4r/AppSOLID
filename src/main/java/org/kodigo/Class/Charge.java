package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodigo.Utils.ConsoleScanner;

import java.util.Scanner;


@AllArgsConstructor
public class Charge {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private double price;


    //With this constructor we initialized a general charge
    public Charge() {
        //First open a little form on the console
        System.out.println("+------------------------------------------+");
        System.out.println("|         NUEVO CARGO DE SERVICIO          |");
        System.out.println("+------------------------------------------+");
        System.out.print("Ingrese el nombre del cargo: ");
        //We get the name of the charge with the ConsoleScanner class
        String name = ConsoleScanner.getString();
        //We initialize a price varible to in order to make it more readable
        double price = 0;
        //We get the price of the cost of this charge
        do {
                System.out.print("Ingrese el costo del cargo: ");
                //Get a double value with the consoleScanner
                price = ConsoleScanner.getDouble();
                //Check if the value is grater than 0
                if(price>0)
                    break;
                //If not repeat until get a value grater than 0
                System.out.println("El dato ingresado es menor a 0");
        }while (true);
        //Update the data of this charge
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){

        return "»  " + this.name + "                $" + this.price ;
    }
}