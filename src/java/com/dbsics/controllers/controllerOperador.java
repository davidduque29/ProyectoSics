/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Maquina;
import com.dbsics.entities.Operador;
import com.dbsics.facade.MaquinaFacade;
import com.dbsics.facade.OperadorFacade;
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
@Named(value = "controllerOperador")
@SessionScoped
public class controllerOperador implements Serializable {

    @EJB
    OperadorFacade operadorFacade;
    private Operador operador;
    private List<Operador> listaOperadores;

    @EJB
    MaquinaFacade MaquinaFacade;
    private Maquina maquina;

    public controllerOperador() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Operador">

    @PostConstruct
    public void initOperador() {
        operador = new Operador();
        maquina = new Maquina();
        listaOperadores = operadorFacade.findAll();
    }

    public List<Operador> listarOperadores() {
        return operadorFacade.findAll();
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public List<Operador> getListaOperadores() {
        return listaOperadores;
    }

    public void setListaOperadores(List<Operador> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public void crearOperador() {
        operador.setCodMaquina(maquina);
        operadorFacade.create(this.operador);
        operador = new Operador();
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

    public void editarOperador() {
        alertaModificar();
        operadorFacade.edit(operador);
        operador = new Operador();
    }

    public String editarOperadorUrl(Operador user) {
        operador = user;
        return "modadminuser";
    }

    public void eliminarOperador(Operador Opera) {
        operadorFacade.remove(Opera);
    }
    //  </editor-fold>
}
