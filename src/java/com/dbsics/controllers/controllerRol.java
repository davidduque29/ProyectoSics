/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Rol;
import com.dbsics.facade.RolFacade;
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
@Named(value = "controllerRol")
@SessionScoped
public class controllerRol implements Serializable {

    @EJB
    RolFacade rolFacade;
    private Rol rol;
    private List<Rol> listaRoles;
    private String ruta;

    private JasperPrint jasperPrint;

    public controllerRol() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Rol"> 

    @PostConstruct
    public void init() {
        rol = new Rol();
        listaRoles = rolFacade.findAll();
    }

    // sics\web\sicspage\reporte
    //SicsProject\\sics\\sicspage\\reporte\\
    public void initRol() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaRoles);
         ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reporterol.jasper");
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
//        jasperPrint = JasperFillManager.fillReport("C:\\Users\\ivandavid\\Desktop\\SicsProject\\sics\\web\\sicspage\\reporte\\reporterol.jasper", new HashMap(), beanCollectionDataSource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        initRol();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=Reporte_Roles.pdf");
        // coge la peticion del usuario y se lo carga al getOuptuStream para que sea descargado
        // con el Servlet le dice que le tiene un archivo para asignar
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        // con el jasperExportManager se lo asigna al exportReportToPdfStream 
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }

    public List<Rol> listarRoles() {
        return rolFacade.findAll();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
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
                + "  title: \"Nuevo Rol!\",\n"
                + "  text: \"El Rol " + rol.getRol()+ " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }
    public void crearRol() {
        try{
        rol.setIdRol(null);
        rolFacade.create(rol);
         alertaCreacion();
        rol = new Rol();  
        }catch(Exception e){
            Mensaje.enviarMensajeErrorGlobal("::Error: El Rol ya existe ::", "");
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

    public void editarRol() {
        alertaModificar();
        rolFacade.edit(rol);
        rol = new Rol();
    }

    public String editarRolUrl(Rol rol) {
        this.rol = rol;
        return "administrador";
    }

    public void eliminarRol(Rol rol) {
        rolFacade.remove(rol);
    }
    // </editor-fold> 
}
