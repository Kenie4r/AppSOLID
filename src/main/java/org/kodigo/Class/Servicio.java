package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Utils.ConsoleScanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    private List<Invoice> listadoFacturas;

    public Servicio(){
        System.out.println("******************************");
        System.out.println("Ingresando Datos para Servicio:");
        System.out.println("******************************\n");
        System.out.println("Ingrese el nombre del Servicio:");
        this.nombre = ConsoleScanner.getString();
        System.out.println("Ingrese quien es el proveedor del servicio:");
        this.proveedor = ConsoleScanner.getString();
        this.fechaSuscripcion = new Date(System.currentTimeMillis()) ;
        listadoFacturas = new ArrayList<>();
    }

    public Servicio(String nombre, String proveedor, Double tarifa, Date fechaSuscripcion) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.tarifa = tarifa;
        this.fechaSuscripcion = fechaSuscripcion;
        this.listadoFacturas = new ArrayList<>();
    }

    public int diasDeServicioActivo(){
        return (int) TimeUnit.DAYS.convert(diferencialdeTiempo(),TimeUnit.MILLISECONDS);
    }

    public int mesesDeServicioActivo(){
        return diasDeServicioActivo()/30;
    }

    public int añosDeServicioActivo(){
        return diasDeServicioActivo()/365;
    }

    public String tiempoTranscurrido(){
        int años = diasDeServicioActivo()/365;
        int meses = (diasDeServicioActivo()%365)/30;
        int diasRestantes= ((diasDeServicioActivo()%365)%30);
        return años+" años, "+meses+" meses, "+diasRestantes+" dias";
    }

    private long diferencialdeTiempo(){
        return Math.abs(System.currentTimeMillis()-this.fechaSuscripcion.getTime());
    }



}
