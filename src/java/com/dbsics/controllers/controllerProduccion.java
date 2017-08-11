/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Produccion;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.ProduccionFacade;
import com.dbsics.facade.UsuarioFacade;
import com.dbsics.util.Mensaje;
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
@Named(value = "controllerProduccion")
@SessionScoped
public class controllerProduccion implements Serializable {

    @EJB
    ProduccionFacade produccionfacade;
    private Produccion produccion;
    private List<Produccion> listarproduccion;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public controllerProduccion() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Produccion">

    @PostConstruct
    public void init() {
        produccion = new Produccion();
        usuario = new Usuario();
        listarproduccion = produccionfacade.findAll();
    }

    public List<Produccion> listarProduccion() {
        return produccionfacade.findAll();
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public List<Produccion> getListarproduccion() {
        return listarproduccion;
    }

    public void setListarproduccion(List<Produccion> listarproduccion) {
        this.listarproduccion = listarproduccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void crearProduccion() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            produccion.setIdProduccion(null);
            produccion.setFechaCreacion(fecha);
            produccion.setAprobador(usuario);
            produccionfacade.create(produccion);
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: Producción ya existe ::", "");
        }
        produccion = new Produccion();
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

    public void editarProduccion() {
        Calendar c = Calendar.getInstance();
        Date fecha = c.getTime();
        produccion.setFechaCreacion(fecha);
        produccion.setAprobador(usuarioFacade.find(usuario.getIdUsuario()));
        alertaModificar();
        produccionfacade.edit(produccion);
        produccion = new Produccion();
    }

    public String editarProduccionUrl(Produccion produccion) {
        this.produccion = produccion;
        return "produccionEditar";

    }

    public void eliminarProduccion(Produccion prod) {
        produccionfacade.remove(prod);
        produccion = new Produccion();
    }
    // </editor-fold>
}
