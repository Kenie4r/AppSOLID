package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Servicio {

    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String proveedor;
    @Getter
    @Setter
    private Double tarifa;
    @Getter
    private Date fechaSuscripcion;

    public Servicio(){
        System.out.println("Recibiendo informacion de servicio:");
        System.out.println("Ingrese el nombre del Servicio:");
        this.nombre = ConsoleScanner.getString();
        System.out.println("Ingrese quien es el proveedor del servicio:");
        this.proveedor = ConsoleScanner.getString();
        this.fechaSuscripcion = new Date(System.currentTimeMillis()) ;
    }

    public int duracionDeServicio(){
        return this.fechaSuscripcion.compareTo(new Date(System.currentTimeMillis()));
    }

    public Servicio(String nombre, String proveedor, Double tarifa, Date fechaSuscripcion) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.tarifa = tarifa;
        this.fechaSuscripcion = fechaSuscripcion;
    }



}
