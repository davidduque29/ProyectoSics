/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Estadoplanaccion;
import com.dbsics.entities.Novedad;
import com.dbsics.entities.Plandeaccion;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.EstadoplanaccionFacade;
import com.dbsics.facade.NovedadFacade;
import com.dbsics.facade.PlandeaccionFacade;
import com.dbsics.facade.UsuarioFacade;
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
@Named(value = "controllerPlanDeAccion")
@SessionScoped
public class controllerPlanDeAccion implements Serializable {

    @EJB
    PlandeaccionFacade planDeAccionFacade;
    private Plandeaccion plandeaccion;
    private List<Plandeaccion> listaPlanesdeaccion;

    @EJB
    NovedadFacade novedadFacade;
    private Novedad novedad;

    @EJB
    EstadoplanaccionFacade EstadoplanaccionFacade;
    private Estadoplanaccion estadoplanaccion;

    @EJB
    UsuarioFacade UsuarioFacade;
    private Usuario usuario;
    JasperPrint jasperPrint;
    private String ruta;

    public controllerPlanDeAccion() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Plan De Accion">
    
    @PostConstruct
    public void initPlanDeAccion() {
        plandeaccion = new Plandeaccion();
        estadoplanaccion = new Estadoplanaccion();
        listaPlanesdeaccion = planDeAccionFacade.findAll();
        novedad = new Novedad();
        usuario = new Usuario();
    }

    public List<Plandeaccion> listarPlanesDeAccion() {
        return planDeAccionFacade.findAll();
    }

    public void initPreProd() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaPlanesdeaccion);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reportePlandeAccion.jasper");
        initPreProd();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte Preproduccion.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public Plandeaccion getPlandeaccion() {
        return plandeaccion;
    }

    public void setPlandeaccion(Plandeaccion plandeaccion) {
        this.plandeaccion = plandeaccion;
    }

    public List<Plandeaccion> getListaPlanesdeaccion() {
        return listaPlanesdeaccion;
    }

    public void setListaPlanesdeaccion(List<Plandeaccion> listaPlanesdeaccion) {
        this.listaPlanesdeaccion = listaPlanesdeaccion;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public Estadoplanaccion getEstadoplanaccion() {
        return estadoplanaccion;
    }

    public void setEstadoplanaccion(Estadoplanaccion estadoplanaccion) {
        this.estadoplanaccion = estadoplanaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void crearPlanDeAccion() {
        plandeaccion.setIdPlanDeAccion(null);
        plandeaccion.setCodNovedad(novedadFacade.find(novedad.getIdNovedad()));
        plandeaccion.setUsuarioRegistro(UsuarioFacade.find(usuario.getIdUsuario()));
        plandeaccion.setEstado(EstadoplanaccionFacade.find(estadoplanaccion.getIdEstadoPlanAccion()));
        planDeAccionFacade.create(plandeaccion);
        plandeaccion = new Plandeaccion();
    }

    public void editarPreproduccionprod() {
        planDeAccionFacade.edit(plandeaccion);
        plandeaccion = new Plandeaccion();
    }

    public String editarPreproduccionprodUrl(Plandeaccion preproduccionprod) {
        this.plandeaccion = preproduccionprod;
        return "editarPreproduccionprod";

    }

    public void eliminarPreproduccionprod(Plandeaccion plandeaccion) {
        planDeAccionFacade.remove(plandeaccion);
        plandeaccion = new Plandeaccion();
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

    public void editarPlanDeAccion() {
        alertaModificar();
        planDeAccionFacade.edit(plandeaccion);
        plandeaccion = new Plandeaccion();

    }

    public String editarPlanDeAccionUrl(Plandeaccion plan) {
        this.plandeaccion = plan;
        return "editarplan";

    }
    // </editor-fold>
}
