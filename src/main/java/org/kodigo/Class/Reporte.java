package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.kodigo.Interfaces.IReporte;

import java.util.*;

public class Reporte implements IReporte {
    @Setter
    @Getter
    private Date dataOfCreate;

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


    @Override
    public void GenerarReporte() {
        List<Reporte> lista_F = new ArrayList<>();
        Reporte reporte = new Reporte();
        reporte.setTotal("100.00");
        Servicio service = new Servicio();
        service.setNombre("Agua");
        reporte.setServicename(service.getNombre());
        Charge charge = new Charge();
        charge.setName("Agua");
        charge.setPrice(110.00);

        Charge charge1 = new Charge();
        charge1.setName("Luz");
        charge1.setPrice(120.00);

        List<Charge> chargeList = new ArrayList<>();
        chargeList.add(charge);
        chargeList.add(charge1);

        reporte.setTotalcargos(chargeList.size());
        lista_F.add(reporte);
        System.out.println(reporte.getTotal());

        try {
            String path = "src/main/java/org/kodigo/resource/ReporteFactura.jasper";
            JRBeanCollectionDataSource items = new JRBeanCollectionDataSource(chargeList);
            Map<String, Object> parameters = new HashMap<String,Object>();
            parameters.put("Parameter1", items);
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint print = JasperFillManager.fillReport(report,parameters, new JRBeanCollectionDataSource(lista_F));
            JasperViewer visualizador = new JasperViewer(print,false);
            visualizador.setTitle("Reporte");
            visualizador.setVisible(true);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
