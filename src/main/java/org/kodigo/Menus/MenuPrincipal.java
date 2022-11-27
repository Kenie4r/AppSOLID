package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.ConsoleScanner;
import org.kodigo.Utils.ScreenCleaner;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal implements IMenu {

    private  List<Casa> listadoCasas;

    MenuPrincipal(){
        listadoCasas = new ArrayList<>();
    }
    private  boolean addCasa(Casa casa){
        listadoCasas.add(casa);
        return true;
    }

    private void listarCasas(){
        System.out.println("Lista de casas");
        int i = 0;

        System.out.println("N° - Codigo - Propietario");

        for (Casa casa : listadoCasas){
            System.out.println(i + "  -   " + casa.getCodigoCasa() + "    - " + casa.getPropietario().getPersonName());
            i++;
        }
    }

    @Override
    public void lanzarMenu() {
        ScreenCleaner.cleanScreen();
        imprimirOpciones();
        tomarOpcion();
    }

    private void imprimirOpciones(){
        System.out.println("\n***************************************");
        System.out.println("**      MenuPrincipal principal      **");
        System.out.println("**       Seleccione una opcion       **");
        System.out.println("***************************************\n");
        listarCasas();
        System.out.println("\n***************************************");
        System.out.println("**            * Opciones *           **");
        System.out.println("**            ************           **");
        System.out.println("**                                   **");
        System.out.println("**          a - Agregar casa         **");
        System.out.println("**    No. Casa - Seleccionar casa    **");
        System.out.println("**      r - Apartado de reportes     **");
        System.out.println("**    salir - Finalizar aplicacion   **");
        System.out.println("***************************************\n");
    }

    private void tomarOpcion(){
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                addCasa(new Casa());
                lanzarMenu();
                break;
            case "r":
                lanzarMenuReportes();
                break;
            case "salir":
                cerrarAplicacion();
                break;
            case "Salir":
                cerrarAplicacion();;
                break;
            case "SALIR":
                cerrarAplicacion();
            default:
                System.out.println("La Opcion no se Encuentra en el Menu");
        }

        if(esNumero(opciones)){
            System.out.println("esNumero: "+esNumero(opciones));
            lanzarMenuCasas(parsearAIndex(opciones));
        }
    }

    private boolean esNumero(String string){
        String regex = "^[0-9]+$";
        return string.matches(regex);
    }
    private int parsearAIndex(String index){
        return Integer.parseInt(index);
    }

    private void lanzarMenuReportes(){
        ScreenCleaner.cleanScreen();
        System.out.println("Opcion -Reportes");
    }

    private void lanzarMenuCasas(int index){
        ScreenCleaner.cleanScreen();
        System.out.println("Se eligio la Casa: "+ index);
    }

    private void cerrarAplicacion(){
        ConsoleScanner.closeScanner();
        ScreenCleaner.cleanScreen();
        System.exit(0);
    };
}
