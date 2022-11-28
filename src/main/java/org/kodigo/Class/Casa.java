package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Utils.ConsoleScanner;
import org.kodigo.Utils.PauseScreen;
import org.kodigo.Utils.ScreenCleaner;

import java.util.ArrayList;
import java.util.List;


/*Casa es una Clase de Datos, que se encarga de Almacenar los Datos de una Casa o vivienda.
Dentro de la casa Habitan personas que hacen uso de servicios, la aplicacion guarda la informacion
Para luego utilizarla para enviar notificaciones por correo y enviar reportes.
* */

/*
* Agrega Personas, Servicios y Facturas a la Casa.
*
* */

public class Casa {
    @Getter
    @Setter
    private int codigoCasa;
    @Getter
    private final String pais = "El Salvador";
    @Getter
    @Setter
    private String departamento;
    @Getter
    @Setter
    private String municipio;
    @Getter
    @Setter
    private Integer numeroCasa;
    @Getter
    @Setter
    private Person propietario;
    private List<Person> listadoPersonas;
    private List<Servicio> listadoServicios;
    @Getter
    private Double costoMantenimiento;
    private List<Invoice> listadoFacturas;


    public Casa(){
        ScreenCleaner.cleanScreen();
        System.out.println("***************************");
        System.out.println("Ingresando Datos para Casa:");
        System.out.println("***************************\n");
        System.out.println("Por favor Ingrese el Identificador de la Casa:");
        this.codigoCasa = ConsoleScanner.getInteger();
        System.out.println("Direccion de la Casa:");
        System.out.println("Pais: "+this.pais+"\n");
        System.out.println("Por favor Ingrese el Departamento de la casa:");
        this.departamento = ConsoleScanner.getString();
        System.out.println("Por favor Ingrese el Municipio:");
        this.municipio = ConsoleScanner.getString();
        System.out.println("Ingrese el numero de la Casa:");
        this.numeroCasa = ConsoleScanner.getInteger();
        System.out.println("Por favor Ingrese el Propietario de la Casa:");
        propietario = new Person("admin", ConsoleScanner.getString(),"admin@admin.com");
        listadoPersonas = new ArrayList<>();
        listadoServicios = new ArrayList<>();
        listadoFacturas = new ArrayList<>();
    }

    public Casa(int codigoCasa, String departamento, String municipio, Integer numeroCasa, Person propietario, Double costoMantenimiento) {
        this.codigoCasa = codigoCasa;
        this.departamento = departamento;
        this.municipio = municipio;
        this.numeroCasa = numeroCasa;
        this.propietario = propietario;
        this.costoMantenimiento = costoMantenimiento;
        this.listadoPersonas = new ArrayList<>();
        this.listadoServicios = new ArrayList<>();
        this.listadoFacturas = new ArrayList<>();
    }

    public boolean addPersona(){
        ScreenCleaner.cleanScreen();
        listadoPersonas.add(new Person());
        return true;
    }

    public boolean addPersona(Person persona){
        listadoPersonas.add(persona);
        return true;
    }

    public void listarPersonas(){
        if(listadoPersonas.size() > 0){
            System.out.println("Lista de Personas en casa " + codigoCasa + " :");
            int index = 0;
            System.out.println("No. -  Nombre");
            for (Person persona:listadoPersonas) {
                System.out.println(index+ "   -  "+persona.getPersonName());
                index++;
            }
        }
    }

    public boolean addServicios(Servicio servicio){
        System.out.println("Suscrito a: "+servicio.getNombre());
        listadoServicios.add(servicio);
        return true;
    }

    public void listarServicios(){
        System.out.println("Servicios en la Casa:");
        int index = 0;
        System.out.println("No. -  Servicio      - Proveedor");
        for (Servicio servicio : listadoServicios) {
            System.out.println(index + "   -   "+servicio.getNombre()+"   -   "+servicio.getProveedor());
            index++;
        }
    }

    public void actualizarCostoMantenimiento(Double nuevoCosto){
        this.costoMantenimiento = nuevoCosto;
    }

    public boolean sobrepasaIndexPersona(int indexCasa){
        return indexCasa < listadoPersonas.size() && listadoPersonas.size() >0;
    }

    public void eliminarPersona(int index){
        this.listadoPersonas.remove(index);
    }

    public void cambiarPerson(int index){
        this.listadoPersonas.set(index,new Person());
    }

    public void eliminarServicio(int index){
        this.listadoServicios.remove(index);
    }


}
