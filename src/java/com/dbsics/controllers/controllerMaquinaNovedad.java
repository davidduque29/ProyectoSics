/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Maquina;
import com.dbsics.entities.Maquinanovedad;
import com.dbsics.entities.Novedad;
import com.dbsics.facade.MaquinaFacade;
import com.dbsics.facade.MaquinanovedadFacade;
import com.dbsics.facade.NovedadFacade;
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
@Named(value = "controllerMaquinaNovedad")
@SessionScoped
public class controllerMaquinaNovedad implements Serializable {

    @EJB
    MaquinanovedadFacade maquinaNovedadFacade;
    private Maquinanovedad maquinaNovedad;
    private List<Maquinanovedad> listarMaquinaNovedad;

    @EJB
    MaquinaFacade maquinaFacade;
    private Maquina maquina;
    private List<Maquina> listaMaquinas;

    @EJB
    NovedadFacade novedadFacade;
    private Novedad novedad;

    public controllerMaquinaNovedad() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Maquina Novedad">
    @PostConstruct
    public void init() {
        maquinaNovedad = new Maquinanovedad();
        novedad = new Novedad();
        maquina = new Maquina();
        listarMaquinaNovedad = maquinaNovedadFacade.findAll();
        listaMaquinas = maquinaFacade.findAll();
    }
    public List<Maquinanovedad> listarMaquinaNovedad() {
        return maquinaNovedadFacade.findAll();
    }
    public Maquinanovedad getMaquinaNovedad() {
        return maquinaNovedad;
    }

    public void setMaquinaNovedad(Maquinanovedad maquinaNovedad) {
        this.maquinaNovedad = maquinaNovedad;
    }

    public List<Maquinanovedad> getListarMaquinaNovedad() {
        return listarMaquinaNovedad;
    }

    public void setListarMaquinaNovedad(List<Maquinanovedad> listarMaquinaNovedad) {
        this.listarMaquinaNovedad = listarMaquinaNovedad;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }
    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nueva Novedad Máquina!\",\n"
                + "  text: \"La Novedad para la máquina " + maquinaNovedad.getCodMaquina().getMaquina() + " fue creada exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearMaquinaNovedad() {
        try {
            maquinaNovedad.setIdMaquinaNovedad(null);
            maquinaNovedad.setCodMaquina(maquina);
            maquinaNovedad.setCodNovedad(novedad);
            maquinaFacade.create(maquina);
            alertaCreacion();
            maquinaNovedad = new Maquinanovedad();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("Erro crear", "error datos");
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

    public void editarMaquinaNovedad() {
        maquinaNovedadFacade.edit(maquinaNovedad);
        alertaModificar();
        maquinaNovedad = new Maquinanovedad();
    }

    public String editarMaquinaNovedadUrl(Maquinanovedad maquinaNov) {
        maquinaNovedad = maquinaNov;
        return "editarmaquinanovedad";
    }

    public void eliminarMaquinaNovedad(Maquinanovedad maquinaNov) {
        maquinaNovedadFacade.remove(maquinaNovedad);
    }
    // </editor-fold>
    
}
