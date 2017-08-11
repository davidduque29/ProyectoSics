/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Preproduccion;
import com.dbsics.entities.Solicitudmaterial;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.PreproduccionFacade;
import com.dbsics.facade.SolicitudmaterialFacade;
import com.dbsics.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerSolicitudMaterial")
@SessionScoped
public class controllerSolicitudMaterial implements Serializable {

    @EJB
    SolicitudmaterialFacade solicitudMateFacade;
    private Solicitudmaterial solicitudmaterial;
    private List<Solicitudmaterial> listaSolicitud;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    @EJB
    PreproduccionFacade preproduccionFacade;
    private Preproduccion preproduccion;

    public controllerSolicitudMaterial() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Solicitud Material">

    @PostConstruct
    public void initSolicitudMaterial() {
        solicitudmaterial = new Solicitudmaterial();
        listaSolicitud = solicitudMateFacade.findAll();
        usuario = new Usuario();
        preproduccion = new Preproduccion();
    }

    public List<Solicitudmaterial> listarMaterialSolicitado() {
        return solicitudMateFacade.findAll();
    }

    public Solicitudmaterial getSolicitudmaterial() {
        return solicitudmaterial;
    }

    public void setSolicitudmaterial(Solicitudmaterial solicitudmaterial) {
        this.solicitudmaterial = solicitudmaterial;
    }

    public List<Solicitudmaterial> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(List<Solicitudmaterial> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Preproduccion getPreproduccion() {
        return preproduccion;
    }

    public void setPreproduccion(Preproduccion preproduccion) {
        this.preproduccion = preproduccion;
    }

    public void crearMaterial() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            solicitudmaterial.setIdSolicitudMaterial(null);
            solicitudmaterial.setFechaCreacion(fecha);
            solicitudmaterial.setCodUsuario(usuario);
            solicitudmaterial.setCodPreProduccion(preproduccion);
            solicitudMateFacade.create(solicitudmaterial);

            Mailer.send("cesarsan121@hotmail.com", "Solicitud de material", "Ha recibido una solicitud de material número: "
                    + solicitudmaterial.getIdSolicitudMaterial() + "\n registrado por: " + solicitudmaterial.getCodUsuario().getNombreCompleto() + "\n (Gestor de materiales)");
            solicitudmaterial = new Solicitudmaterial();
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

    public void editarMaterial() {
        alertaModificar();
        solicitudMateFacade.edit(solicitudmaterial);
        solicitudmaterial = new Solicitudmaterial();
    }

    public String editarMaterialUrl(Solicitudmaterial material) {
        this.solicitudmaterial = material;
        return "editarsolicitudmaterial";
    }

    public void eliminarMaterial(Solicitudmaterial material) {
        solicitudMateFacade.remove(material);
    }
    // </editor-fold >

}
