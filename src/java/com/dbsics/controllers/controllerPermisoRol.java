/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Permiso;
import com.dbsics.entities.Permisorol;
import com.dbsics.entities.Rol;
import com.dbsics.facade.PermisoFacade;
import com.dbsics.facade.PermisorolFacade;
import com.dbsics.facade.RolFacade;
import com.dbsics.util.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerPermisoRol")
@SessionScoped
public class controllerPermisoRol implements Serializable {

    @EJB
    PermisorolFacade permisorolFacade;
    private Permisorol permisorol;
    private List<Permisorol> listaPermisosRol;

    @EJB
    RolFacade rolFacade;
    private Rol rol;

    @EJB
    PermisoFacade permisoFacade;
    private Permiso permiso;

    public controllerPermisoRol() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Permiso Rol">

    @PostConstruct
    public void initPermisoRol() {
        permisorol = new Permisorol();
        listaPermisosRol = permisorolFacade.findAll();
        rol = new Rol();
        permiso = new Permiso();

    }

    public List<Permisorol> listarPermisosRol() {
        return permisorolFacade.findAll();
    }

    public Permisorol getPermisorol() {
        return permisorol;
    }

    public void setPermisorol(Permisorol permisorol) {
        this.permisorol = permisorol;
    }

    public List<Permisorol> getListaPermisosRol() {
        return listaPermisosRol;
    }

    public void setListaPermisosRol(List<Permisorol> listaPermisosRol) {
        this.listaPermisosRol = listaPermisosRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Permiso Rol!\",\n"
                + "  text: \"El Permiso Rol " + permisorol.getIdPermisoRol() +"para el Rol: "+rol.getRol()+ " fue creado exitosamente. para\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearPermisoRol() {
        try {
            permisorol.setIdPermisoRol(null);
            permisorol.setCodRol(rolFacade.find(rol.getIdRol()));
            permisorol.setCodPermiso(permisoFacade.find(permiso.getIdPermiso()));
            permisorolFacade.create(this.permisorol);
            alertaCreacion();
            this.permisorol = new Permisorol();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("::Error: El Permiso Rol ya existe ::", "");
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

    public void editarPermisoRol() {
        alertaModificar();
        permisorolFacade.edit(permisorol);
        permisorol = new Permisorol();
    }

    public String editarPermisoRolUrl(Permisorol permiso) {
        this.permisorol = permiso;
        return "modaminpermiso";
    }

    public void eliminarRolPermiso(Permisorol permiso) {
        this.permisorol = permiso;
        permisorolFacade.remove(permisorol);
    }
    // </editor-fold>
}
