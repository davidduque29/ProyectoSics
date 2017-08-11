/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Preproceso;
import com.dbsics.facade.PreprocesoFacade;
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
@Named(value = "controllerPreproceso")
@SessionScoped
public class controllerPreProceso implements Serializable {

    @EJB
    PreprocesoFacade preprocesoFacade;
    private Preproceso preProceso;
    private List<Preproceso> listaPreProcesos;

    public controllerPreProceso() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Pre Proceso">

    @PostConstruct
    public void initPreProceso() {
        preProceso = new Preproceso();
        listaPreProcesos = preprocesoFacade.findAll();
    }

    public List<Preproceso> listarPreProceso() {
        return preprocesoFacade.findAll();
    }

    public Preproceso getPreProceso() {
        return preProceso;
    }

    public void setPreProceso(Preproceso preProceso) {
        this.preProceso = preProceso;
    }

    public List<Preproceso> getListaPreProcesos() {
        return listaPreProcesos;
    }

    public void setListaPreProcesos(List<Preproceso> listaPreProcesos) {
        this.listaPreProcesos = listaPreProcesos;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo preProceso!\",\n"
                + "  text: \"El preProceso " + preProceso.getPreProceso() + " fue creado exitosamente.\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearPreProcesos() {
        try {
            preProceso.setIdPreProceso(null);
            preprocesoFacade.create(this.preProceso);
            alertaCreacion();
            preProceso = new Preproceso();

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

    public void editarPreProceso() {
        alertaModificar();
        preprocesoFacade.edit(preProceso);
        preProceso = new Preproceso();
    }

    public String editarPreProcesoUrl(Preproceso pre) {
        preProceso = pre;
        return "modadminuser";
    }

    public void eliminarPreProceso(Preproceso pre) {
        preprocesoFacade.remove(preProceso);
    }

    // </editor-fold>
}
