package org.kodigo.Menus;

import org.kodigo.Class.Casa;
import org.kodigo.Interfaces.IMenu;
import org.kodigo.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends MenuOpciones {

    private  List<Casa> listadoCasas;

    MenuPrincipal(){
        listadoCasas = new ArrayList<>();
    }

    @Override
    public void lanzarEsteMenu() {
        ScreenCleaner.cleanScreen();
        imprimirOpciones();
        tomarOpcion();
    }

    public void imprimirOpciones(){
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
        //System.out.println("**      r - Apartado de reportes     **");
        System.out.println("**    salir - Finalizar aplicacion   **");
        System.out.println("***************************************\n");
    }

    public void tomarOpcion(){
        String opciones = ConsoleScanner.getSingleString();
        switch (opciones){
            case "a" :
                UtilsListas.añadirALista(new Casa(),listadoCasas);
                lanzarEsteMenu();
                break;
            case "salir":
                CierreGlobal.cerrarAplicacion();
                break;
            case "Salir":
                CierreGlobal.cerrarAplicacion();
                break;
            case "SALIR":
                CierreGlobal.cerrarAplicacion();
                break;
        }

        validarOpcion(opciones);
    }

    @Override
    void validarOpcion(String opcion) {
        if(Validar.esNumero(opcion)){
            int index = Parseador.parsearAIndex(opcion);
            if(UtilsListas.sobrepasaIndex(index,listadoCasas)){
                opcionSeleccionanda(index);
            }else{
                lanzarEsteMenu();
            }
        }else{
            lanzarEsteMenu();
        }
    }

    @Override
    void opcionSeleccionanda(int index) {
        lanzarSiguienteMenu(new MenuCasa(this,listadoCasas.get(index)));
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

}
