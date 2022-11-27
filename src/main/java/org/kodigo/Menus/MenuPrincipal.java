package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.ConsoleScanner;

import java.util.List;

public class MenuPrincipal implements IMenu {

    private static List<Casa> listadoCasas;

    private static void MenuMain(){
        String opciones;

        do {
            System.out.println("MenuPrincipal principal");
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

       private static boolean addCasa(Casa casa){
        listadoCasas.add(casa);
        return true;

    }

    private void listarCasas(){
        System.out.println("Lista de casas");
        int i = 0;

        System.out.println("N° - Codigo Casa-propietario");
        for (Casa casa : listadoCasas){
            System.out.println(i + " - " + casa.getCodigoCasa() + " - " + casa.getPropietario());
            i++;
        }
    }

    @Override
    public void lanzarMenu() {
        MenuMain();
    }

    private void imprimirOpciones(){

    }
}
