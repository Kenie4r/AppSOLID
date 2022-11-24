package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Utils.ConsoleScanner;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Casa> listadoCasas;

    public static void MenuMain(){
        String opciones;

        do {
            System.out.println("Menu principal");
            System.out.println("Seleccione una opcion");
            System.out.println();
            System.out.println("a - Agregar casa");
            System.out.println("numero de casa - Seleccionar casa");
            System.out.println("r - Apartado de reportes");
            System.out.println("salir - Finalizar aplicacion");
            opciones = ConsoleScanner.getString();

            switch (opciones){
                case "a" :
                    addCasa(new Casa());
                    break;
                case "r":
                    System.out.println("opcion r");
                    break;
                case "salir":
                    break;
                default:
                    System.out.println("la opcion no se encuentra en el menu");
            }
            String regex = "^[0-9]+$";
            if (opciones.matches(regex)){

            }
        }while (opciones.length() != 4);
    }

       public static boolean addCasa(Casa casa){
        listadoCasas.add(casa);
        return true;

    }

    public void listarCasas(){
        System.out.println("Lista de casas");
        int i = 0;

        System.out.println("N° - Codigo Casa-propietario");
        for (Casa casa : listadoCasas){
            System.out.println(i + " - " + casa.getCodigoCasa() + " - " + casa.getPropietario());
            i++;
        }
    }
}
