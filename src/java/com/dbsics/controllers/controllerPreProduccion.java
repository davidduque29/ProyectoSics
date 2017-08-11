/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Preproceso;
import com.dbsics.entities.Preproduccion;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.PreprocesoFacade;
import com.dbsics.facade.PreproduccionFacade;
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
@Named(value = "controllerPreProduccion")
@SessionScoped
public class controllerPreProduccion implements Serializable {

    @EJB
    PreproduccionFacade preproduccionfacade;
    private Preproduccion preproduccion;
    private List<Preproduccion> listarPreproduccion;

    @EJB
    PreprocesoFacade preprocesofacade;
    private Preproceso preproceso;

    @EJB
    UsuarioFacade usuariofacade;
    private Usuario Usuario;

    JasperPrint jasperPrint;
    private String ruta;

    public controllerPreProduccion() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código PreProduccion">

    @PostConstruct
    public void init() {
        preproceso = new Preproceso();
        Usuario = new Usuario();
        preproduccion = new Preproduccion();
        listarPreproduccion = preproduccionfacade.findAll();
    }

    public List<Preproduccion> listarPreproduccion() {
        return preproduccionfacade.findAll();
    }

    public void initPreProd() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listarPreproduccion);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reportepreproduccion.jasper");
        initPreProd();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte Preproduccion.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public Preproduccion getPreproduccion() {
        return preproduccion;
    }

    public void setPreproduccion(Preproduccion preproduccion) {
        this.preproduccion = preproduccion;
    }

    public List<Preproduccion> getListarPreproduccion() {
        return listarPreproduccion;
    }

    public void setListarPreproduccion(List<Preproduccion> listarPreproduccion) {
        this.listarPreproduccion = listarPreproduccion;
    }

    public Preproceso getPreproceso() {
        return preproceso;
    }

    public void setPreproceso(Preproceso preproceso) {
        this.preproceso = preproceso;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void crearPreProduccion() {
        try {
            preproduccion.setIdPreProduccion(null);
            preproduccion.setCodPreProceso(preproceso);
            preproduccion.setUsuarioExplosion(Usuario);
            preproduccionfacade.create(this.preproduccion);
            preproduccion = new Preproduccion();
        } catch (Exception e) {
            System.out.println("Error de datos");
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

    public void editarPreproduccion() {
        preproduccion.setUsuarioExplosion(Usuario);
        preproduccion.setCodPreProceso(preproceso);
        alertaModificar();
        preproduccionfacade.edit(preproduccion);
        preproduccion = new Preproduccion();
    }

    public String editarPreproduccionUrl(Preproduccion preprod) {
        this.preproduccion = preprod;
        return "preproduccioneditar";

    }

    public void eliminarPreProduccion(Preproduccion preprod) {
        preproduccionfacade.remove(preproduccion);
    }
    // </editor-fold>
}
