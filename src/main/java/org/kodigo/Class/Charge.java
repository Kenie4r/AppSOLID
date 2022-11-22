package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;


@AllArgsConstructor
public class Charge {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private double price;


    Scanner scanner = new Scanner(System.in);
    public Charge() {
        System.out.println("+------------------------------------------+");
        System.out.println("|         NUEVO CARGO DE SERVICIO          |");
        System.out.println("+------------------------------------------+");
        System.out.println("Ingrese el nombre del cargo: ");
        String name = scanner.nextLine();
        double price = 0;
        do {

            try{
                System.out.println("Ingrese el costo del cargo: ");
                String  priceS = scanner.nextLine();
                price = Double.parseDouble(priceS);
                if(price>0)
                    break;
                System.out.println("El dato ingresado es menor a 0");
            }catch (NumberFormatException ex){
                System.out.println("El dato ingresado no es un número");
            }

        }while (true);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "El cargo es : " + this.name + " con un coste de $" + this.price;
    }
}