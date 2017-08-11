/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Subproceso;
import com.dbsics.facade.SubprocesoFacade;
import com.dbsics.util.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerSubProceso")
@SessionScoped
public class controllerSubProceso implements Serializable {

    @EJB
    SubprocesoFacade subProcesoFacade;
    private Subproceso subProceso;
    List<Subproceso> listaSubproceso;

    public controllerSubProceso() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Sub Proceso">

    @PostConstruct
    public void initSubProceso() {
        subProceso = new Subproceso();
        listaSubproceso = subProcesoFacade.findAll();
    }

    public List<Subproceso> listarSubproceso() {
        return subProcesoFacade.findAll();
    }

    public Subproceso getSubProceso() {
        return subProceso;
    }

    public void setSubProceso(Subproceso subProceso) {
        this.subProceso = subProceso;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo subProceso Rol!\",\n"
                + "  text: \"El subProceso " + subProceso.getSubProceso()+ " fue creado exitosamente.\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearSubProceso() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            subProceso.setFechaCreacion(fecha);
            subProcesoFacade.create(this.subProceso);
            alertaCreacion();
            this.subProceso = new Subproceso();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("::Error: El Sub Proceso ya existe ::", "");
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

    public void editarSubProceso() {
        alertaModificar();
        subProcesoFacade.edit(subProceso);
        subProceso = new Subproceso();
    }

    public String editarSubProcesoUrl(Subproceso subProc) {
        subProceso = subProc;
        return "modadminproceso";
    }

    public void eliminarPreproceso() {
        subProcesoFacade.remove(subProceso);
        subProceso = new Subproceso();
    }
    // </editor-fold>

}
