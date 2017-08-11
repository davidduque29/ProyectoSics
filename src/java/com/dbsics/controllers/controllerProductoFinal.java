/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Produccion;
import com.dbsics.entities.Productofinal;
import com.dbsics.facade.ProduccionFacade;
import com.dbsics.facade.ProductofinalFacade;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerProductoFinal")
@SessionScoped
public class controllerProductoFinal implements Serializable {

    @EJB
    ProductofinalFacade productofinalfacade;
    private Productofinal productofinal;
    private List<Productofinal> listarProductofinal;

    @EJB
    ProduccionFacade produccionfacade;
    private Produccion produccion;

    private JasperPrint jasperPrint;
    private String ruta;

    public controllerProductoFinal() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código ProductoFinal">

    @PostConstruct
    public void init() {

        productofinal = new Productofinal();
        produccion = new Produccion();
        listarProductofinal = productofinalfacade.findAll();
    }

    public void initCargo() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listarProductofinal);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//productoFinal.jasper");
        initCargo();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte cargo.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public List<Productofinal> listarProductofinal() {
        return productofinalfacade.findAll();
    }

    public Productofinal getProductofinal() {
        return productofinal;
    }

    public void setProductofinal(Productofinal productofinal) {
        this.productofinal = productofinal;
    }

    public List<Productofinal> getListarProductofinal() {
        return listarProductofinal;
    }

    public void setListarProductofinal(List<Productofinal> listarProductofinal) {
        this.listarProductofinal = listarProductofinal;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public void crearProductoFinal() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            productofinal.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
            productofinal.setFechaCreacion(fecha);
            productofinalfacade.create(productofinal);
        } catch (Exception e) {
            System.out.println("Error de datos");
        }
        productofinal = new Productofinal();
    }

    public void alertaModificar() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal({\n"
                + "  title: \"¿Esta seguro de modificar?\",\n"
                + "  text: \"No podrá deshacer cambios!\",\n"
                + "  type: \"warning\",\n"
                + "  showCancelButton: true,\n"
                + "  confirmButtonColor: \"#DD6B55\",\n"
                + "  confirmButtonText: \"Si, Modificar!\",\n"
                + "  closeOnConfirm: false\n"
                + "},\n"
                + "function(){\n"
                + "  swal(\"Deleted!\", \"Su registro ha sido modificado.\", \"success\");\n"
                + "});");
    }

    public void editarProductoFinal() {
        productofinal.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
        alertaModificar();
        productofinalfacade.edit(productofinal);
        productofinal = new Productofinal();
    }

    public String editarProductoFinalUrl(Productofinal productof) {
        this.productofinal = new Productofinal();
        return "editarProductofinal";
    }

    public void eliminarProductofinal(Productofinal Product) {
        produccionfacade.remove(produccion);
        productofinal = new Productofinal();
    }

    // </editor-fold>
}
