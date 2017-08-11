/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Cargo;
import com.dbsics.facade.CargoFacade;
import com.dbsics.util.Mensaje;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
@Named(value = "controllerCargo")
@SessionScoped
public class controllerCargo implements Serializable {

    @EJB
    CargoFacade cargoFacade;
    private Cargo cargo;
    private List<Cargo> listaCargos;

    private JasperPrint jasperPrint;

    public controllerCargo() {
    }

    private Part file;
    private String nombre;
    private String pathReal;
    private String ruta; // se crea una variable local
    private int contador;

    // <editor-fold defaultstate="collapsed" desc="Código Cargo"> 
    @PostConstruct
    public void init() {
        cargo = new Cargo();
        listaCargos = cargoFacade.findAll();
    }

    public void initCargo() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaCargos);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reporteCargo.jasper");
        initCargo();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte cargo.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public List<Cargo> listarCargos() {
        return cargoFacade.findAll();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Cargo!\",\n"
                + "  text: \"El Cargo " + cargo.getCargo() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearCargo() {
        try {
            cargo.setIdCargo(null);
            cargoFacade.create(cargo);
            alertaCreacion();
            cargo = new Cargo();
          
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: El Cargo ya existe :: ", "");
        }
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
                + "  swal(\"Modificado!\", \"Su registro ha sido modificado.\", \"success\");\n"
                + "});");
    }

    public void editarCargo() {
        cargoFacade.edit(cargo);
        alertaModificar();
        cargo = new Cargo();
    }

    public String editarCargoUrl(Cargo objcargo) {
        this.cargo = objcargo;
        return "modaminuser";
    }

    public void eliminarCargo(Cargo cargo) {
        cargoFacade.remove(cargo);
    }
    // </editor-fold> 
}
