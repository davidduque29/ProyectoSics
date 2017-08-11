/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Sobrante;
import com.dbsics.entities.Sobrantedetalle;
import com.dbsics.facade.SobranteFacade;
import com.dbsics.facade.SobrantedetalleFacade;
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
@Named(value = "controllerSobranteDetalle")
@SessionScoped
public class controllerSobranteDetalle implements Serializable {

    @EJB
    SobrantedetalleFacade sobranteDetalleFacade;
    private Sobrantedetalle sobranteDetalle;
    private List<Sobrantedetalle> listarDetalleSobrante;

    @EJB
    SobranteFacade sobrantefacade;
    private Sobrante sobrante;

    public controllerSobranteDetalle() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Sobrante Detalle">
    @PostConstruct
    public void init() {
        sobranteDetalle = new Sobrantedetalle();
        sobrante = new Sobrante();
        listarDetalleSobrante = sobranteDetalleFacade.findAll();
    }

    public List<Sobrantedetalle> listarDetalleSobrante() {
        return sobranteDetalleFacade.findAll();
    }

    public Sobrantedetalle getSobranteDetalle() {
        return sobranteDetalle;
    }

    public void setSobranteDetalle(Sobrantedetalle sobranteDetalle) {
        this.sobranteDetalle = sobranteDetalle;
    }

    public List<Sobrantedetalle> getListarDetalleSobrante() {
        return listarDetalleSobrante;
    }

    public void setListarDetalleSobrante(List<Sobrantedetalle> listarDetalleSobrante) {
        this.listarDetalleSobrante = listarDetalleSobrante;
    }

    public Sobrante getSobrante() {
        return sobrante;
    }

    public void setSobrante(Sobrante sobrante) {
        this.sobrante = sobrante;
    }

    public void crearSobrante() {
        try {
            sobrantefacade.create(this.sobrante);
        } catch (Exception e) {
            System.out.println("Error de datos");
        }
        sobrante = new Sobrante();
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

    public void editarSobranteDetalle() {
        alertaModificar();
        sobranteDetalleFacade.edit(sobranteDetalle);
        sobranteDetalle = new Sobrantedetalle();
    }

    public String editarSobranteDetalleUrl(Sobrantedetalle sobraDetalle) {
        this.sobranteDetalle = sobraDetalle;
        return "editarsobrantedetalle";

    }

    public void eliminarSobrante(Sobrantedetalle sobraDetalle) {
        sobranteDetalleFacade.remove(sobraDetalle);
    }
    // </editor-fold>
}
