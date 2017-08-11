/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Rol;
import com.dbsics.entities.Rolusuario;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.RolFacade;
import com.dbsics.facade.RolusuarioFacade;
import com.dbsics.facade.UsuarioFacade;
import com.dbsics.util.Mensaje;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerRolUsuario")
@Dependent
public class controllerRolUsuario {

    @EJB
    RolusuarioFacade rolUsuarioFacade;
    private Rolusuario rolUsuario;
    private List<Rolusuario> listaRolUsuarios;

    @EJB
    RolFacade rolFacade;
    private Rol rol;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public controllerRolUsuario() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Rol Usuario">    
    @PostConstruct
    public void init() {
        rolUsuario = new Rolusuario();
        rol = new Rol();
        usuario = new Usuario();
        listaRolUsuarios = rolUsuarioFacade.findAll();
    }

    public List<Rolusuario> listarRolUsuario() {
        return rolUsuarioFacade.findAll();
    }

    public List<Rolusuario> getListaRolUsuarios() {
        return listaRolUsuarios;
    }

    public void setListaRolUsuarios(List<Rolusuario> listaRolUsuarios) {
        this.listaRolUsuarios = listaRolUsuarios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Rol usuario!\",\n"
                + "  text: \"El Rol: " + rolUsuario.getIdRol() + " fue creado exitosamente para el Usuario: " + rolUsuario.getIdUsuario().getCorreo() + "\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void creaRolUsuario() {
        try {
            rolUsuario.setIdRol(null);
            rolUsuarioFacade.create(rolUsuario);
            alertaCreacion();
            rolUsuario = new Rolusuario();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: Rol Usuario ya existe ::", "");
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

    public void modificarRolUsuario() {
        alertaModificar();
        rolUsuarioFacade.create(rolUsuario);
        rolUsuario = new Rolusuario();

    }

    public String modificarRolUsuarioUrl(Rolusuario rolusuario) {
        this.rolUsuario = rolusuario;
        return "editarpermiso";
    }
    // </editor-fold>
}
