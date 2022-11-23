package org.kodigo.Class;

import java.util.List;

public class Casa {
    private int codigoCasa;
    private final String pais = "El Salvador";
    private String departamento;
    private String municipio;
    private Integer numeroCasa;
    private Person propietario;
    private int cuentaPersona = 0;
    private List<Person> listadoPersonas;
    private List<Servicio> listadoServicios;
    private Double costoMantenimiento;
    private List<Factura> listadoFacturas;
}
