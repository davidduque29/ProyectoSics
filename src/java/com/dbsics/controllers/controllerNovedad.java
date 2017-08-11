/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Novedad;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.NovedadFacade;
import com.dbsics.facade.UsuarioFacade;
import com.dbsics.util.Mensaje;
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
@Named(value = "controllerNovedad")
@SessionScoped
public class controllerNovedad implements Serializable {

    @EJB
    NovedadFacade novedadFacade;
    private Novedad novedad;
    private List<Novedad> listaNovedades;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    JasperPrint jasperPrint;
    private String ruta;

    public controllerNovedad() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Novedad">

    @PostConstruct
    public void initNovedad() {
        novedad = new Novedad();
        usuario = new Usuario();
        listaNovedades = novedadFacade.findAll();
    }

    public void initPreProd() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaNovedades);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reporteNovedades.jasper");
        initPreProd();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte Preproduccion.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public List<Novedad> listarNovedades() {
        return novedadFacade.findAll();
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public List<Novedad> getListaNovedades() {
        return listaNovedades;
    }

    public void setListaNovedades(List<Novedad> listaNovedades) {
        this.listaNovedades = listaNovedades;
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

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Novedad!\",\n"
                + "  text: \"El Novedad " + novedad.getNovedad() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearNovedad() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            novedad.setIdNovedad(null);
            novedad.setFechaNovedad(fecha);
            novedad.setCodUsuario(usuario);
            alertaCreacion();
            novedadFacade.create(this.novedad);
            novedad = new Novedad();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: Novedad ya existe ::", "");
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

    public void editarNovedad() {
        novedadFacade.edit(novedad);
        alertaModificar();
        novedad = new Novedad();
    }

    public String editarNovedadUrl(Novedad nov) {
        novedad = nov;
        return "modadminuser";
    }

    public void eliminarNovedad(Novedad novedad) {
        novedadFacade.remove(novedad);
    }
    // </editor-fold>
}
