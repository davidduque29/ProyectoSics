/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;


import com.dbsics.facade.StockmaterialFacade;
import com.dbsics.util.ReporteSobrante;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
//import jxl.write.DateTime;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerGraficos")
@SessionScoped
public class controllerGraficos implements Serializable {

    @EJB
    StockmaterialFacade stockmaterialFacade;
    private ReporteSobrante reporteSobrante;
    JasperPrint jasperPrint;

    public controllerGraficos() {
    }
    private String material;
    private int cantidad;

    // <editor-fold defaultstate="collapsed" desc="Código Gráfico">
    // se crea un lista de la clase auxiliar que se creo
    List<ReporteSobrante> listaReporte;
    // se crea la ruta que tiene acceso al reporte
    String ruta;

    @PostConstruct
    public void init() {

        reporteSobrante = new ReporteSobrante();
        listaReporte = new ArrayList<>();
    }

    public void initReporte() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaReporte);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
//      jasperPrint = JasperFillManager.fillReport("C:\\Users\\ivandavid\\Desktop\\reporte.jasper", new HashMap(),beanCollectionDataSource);

    }

    public void generarGrafico(ActionEvent actionEvent) throws JRException, IOException {
        List<Object[]> listaObjeto = stockmaterialFacade.reporteSobrante();
        System.out.println(listaObjeto);

        for (Object[] obj : listaObjeto) {
            ReporteSobrante reporteSobrante = new ReporteSobrante();
//            datos de la clase auxiliar
//            usamos las variables que se crearon en la clase auxiliar y las casteamos .tostring
//              para castear enteros Integer.parseInt
            reporteSobrante.setMaterial(obj[0].toString());
            reporteSobrante.setCantidad(Integer.parseInt(obj[1].toString()));

//             reporteSobrante.setCantidad(Integer.parseInt(obj[1].toString()));
//            reporteSobrante.setFechaCreacion(new Date( obj[3].toString()));
            listaReporte.add(reporteSobrante);
        }
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reportesobrantes.jasper");
        // se envia la ruta
        initReporte();

        // se hace una peticion al facecontext para que traiga el reporte
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporteSobrantes.pdf");
        // coge la peticion del usuario y se lo carga al getOuptuStream para que sea descargado
        // con el Servlet le dice que le tiene un archivo para asignar
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        // con el jasperExportManager se lo asigna al exportReportToPdfStream 
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }
// fin metodo reporte

    public ReporteSobrante getReportePerdida() {
        return reporteSobrante;
    }

    public void setReportePerdida(ReporteSobrante reporteSobrante) {
        this.reporteSobrante = reporteSobrante;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // </editor-fold> 
}
