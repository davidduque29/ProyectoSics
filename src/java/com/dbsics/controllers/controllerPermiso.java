/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Permiso;
import com.dbsics.facade.PermisoFacade;
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
@Named(value = "controllerPermiso")
@SessionScoped
public class controllerPermiso implements Serializable {

    @EJB
    PermisoFacade permisoFacade;
    private Permiso permiso;
    private List<Permiso> listaPermiso;
    private String ruta = "";

    public controllerPermiso() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Permiso">
    @PostConstruct
    public void initMenu() {
        permiso = new Permiso();
        listaPermiso = permisoFacade.findAll();
    }

    public List<Permiso> listarPermisos() {
        return permisoFacade.findAll();
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public List<Permiso> getListaPermiso() {
        return listaPermiso;
    }

    public void setListaPermiso(List<Permiso> listaPermiso) {
        this.listaPermiso = listaPermiso;
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
                + "  title: \"Nuevo Menú!\",\n"
                + "  text: \"El Menú " + permiso.getMenu() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }
    public void crearPermiso() {
        permiso.setIdPermiso(null);
        String ruta = "/sics2017/faces/sicspage/modulo";
        String extension = ".xthml";
        permiso.setMenuPadre(permisoFacade.find(permiso.getIdPermiso()));
        permiso.setUrl(ruta + permiso.getUrl() + extension);
        alertaCreacion();
        permisoFacade.create(permiso);
        permiso = new Permiso();
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

    public void editarPermiso() {
        permiso.setMenuPadre(permiso);
        alertaModificar();
        permisoFacade.edit(permiso);
        permiso = new Permiso();
    }

    public String editarPermisoUrl(Permiso permiso) {
        this.permiso = permiso;
        return "menulistar";
    }

    public void eliminarPermiso(Permiso permiso) {
        permisoFacade.remove(permiso);
        permiso = new Permiso();
    }

    // </editor-fold>
}
