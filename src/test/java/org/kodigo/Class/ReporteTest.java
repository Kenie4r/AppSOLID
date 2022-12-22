package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ReporteTest {

    @Test
    void generarReporteTest(){
        List<Charge> listaCargos = new ArrayList();
        listaCargos.add(new Charge("Cargo 1",1.0));
        listaCargos.add(new Charge("Cargo 2",1.0));
        Reporte reporte = new Reporte("Servicio de Prueba",2,"2",listaCargos);
        assertAll(reporte::GenerarReporte);
    }
}
