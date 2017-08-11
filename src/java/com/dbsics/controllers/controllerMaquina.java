/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Maquina;
import com.dbsics.entities.Tipomaquina;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.MaquinaFacade;
import com.dbsics.facade.TipomaquinaFacade;
import com.dbsics.facade.UsuarioFacade;
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
@Named(value = "controllerMaquina")
@SessionScoped
public class controllerMaquina implements Serializable {

    @EJB
    MaquinaFacade maquinaFacade;
    private Maquina maquina;
    private List<Maquina> listaMaquinas;

    @EJB
    TipomaquinaFacade tipoMaquinaFacade;
    private Tipomaquina tipoMaquina;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public controllerMaquina() {
    }
    private String ruta;
    // <editor-fold defaultstate="collapsed" desc="Código Máquina"> 

    @PostConstruct
    public void initMaquina() {
        maquina = new Maquina();
        listaMaquinas = maquinaFacade.findAll();
        tipoMaquina = new Tipomaquina();
        usuario = new Usuario();
    }

    public List<Maquina> listarMaquinas() {
        return maquinaFacade.findAll();
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public List<Maquina> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(List<Maquina> listaMaquinas) {
        this.listaMaquinas = listaMaquinas;
    }

    public Tipomaquina getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(Tipomaquina tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
                + "  title: \"Nueva Máquina!\",\n"
                + "  text: \"La máquina " + maquina.getMaquina() + " fue creada exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearMaquina() {
        try {
            maquina.setIdMaquina(null);
            maquina.setUsuarioRegistro(usuarioFacade.find(usuario.getIdUsuario()));
            maquina.setCodTipo(tipoMaquinaFacade.find(tipoMaquina.getIdTipoMaquina()));
            maquinaFacade.create(maquina);
            alertaCreacion();
            maquina = new Maquina();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: Serial Máquina ya existe ::", "");
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

    public void editarMaquina() {
        maquinaFacade.edit(maquina);
        alertaModificar();
        tipoMaquina = new Tipomaquina();
    }

    public String editarMaquinaUrl(Maquina maq) {
        maquina = maq;
        return "editarmaquina";
    }

    public void eliminarMaquina(Maquina maquina) {
        maquinaFacade.remove(maquina);
    }
    // </editor-fold> 
}
