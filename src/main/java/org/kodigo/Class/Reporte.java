package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.kodigo.Interfaces.IReporte;
import org.kodigo.Utils.Logger;

import java.util.*;

public class Reporte implements IReporte {


    @Setter
    @Getter
    private String servicename;

    @Setter
    @Getter
    private List<Charge> charges;

    @Setter
    @Getter
    private int totalcargos;


    @Setter
    @Getter
    private String total;

    public Reporte(String servicename, int numeroCargos, String total, List<Charge> charges){
        this.servicename = servicename;
        this.totalcargos = numeroCargos;
        this.total = total;
        this.charges = charges;
    }

    public Reporte(Invoice factura){
        this.servicename = factura.getService().getNombre();
        this.totalcargos = factura.getCharges().size();
        this.total = String.valueOf(factura.getTotal());
        this.charges = factura.getCharges();
    }

    @Override
    public void GenerarReporte() {



        try {
            String path = "ReporteFactura.jasper";
            JRBeanCollectionDataSource items = new JRBeanCollectionDataSource(this.getCharges());

            Map<String, Object> parameters = new HashMap<String,Object>();
            parameters.put("Parameter1", items);
            parameters.put("serviceName",   this.servicename);
            parameters.put("TotalCargos",   this.totalcargos);
            parameters.put("Total",   this.total);

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint print = JasperFillManager.fillReport(report,parameters, new JREmptyDataSource());
            JasperViewer visualizador = new JasperViewer(print,false);
            visualizador.setTitle("Reporte");
            visualizador.setVisible(true);
        } catch (JRException e) {
            Logger.logError(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
