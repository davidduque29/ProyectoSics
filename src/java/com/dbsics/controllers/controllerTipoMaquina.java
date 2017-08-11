/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Tipomaquina;
import com.dbsics.facade.TipomaquinaFacade;
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
@Named(value = "controllerTipoMaquina")
@SessionScoped
public class controllerTipoMaquina implements Serializable {

    @EJB
    TipomaquinaFacade tipoMaquinaFacade;
    private Tipomaquina tipoMaquina;
    private List<Tipomaquina> listaTipoMaquinas;

    public controllerTipoMaquina() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Tipo Máquina">  

    @PostConstruct
    public void initTipoMaquina() {
        tipoMaquina = new Tipomaquina();
        listaTipoMaquinas = tipoMaquinaFacade.findAll();
    }

    public List<Tipomaquina> listarMaquinas() {
        return tipoMaquinaFacade.findAll();
    }

    public Tipomaquina getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(Tipomaquina tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public List<Tipomaquina> getListaTipoMaquinas() {
        return listaTipoMaquinas;
    }

    public void setListaTipoMaquinas(List<Tipomaquina> listaTipoMaquinas) {
        this.listaTipoMaquinas = listaTipoMaquinas;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Tipo Máquina!\",\n"
                + "  text: \"El Tipo Máquina " + tipoMaquina.getTipo() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearTipoMaquina() {
        try {
            tipoMaquina.setIdTipoMaquina(null);
            tipoMaquinaFacade.create(this.tipoMaquina);
            alertaCreacion();
            tipoMaquina = new Tipomaquina();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("::Error: El Tipo Máquina ya existe ::", "");
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

    public void editarTipoMaquina() {
        alertaModificar();
        tipoMaquinaFacade.edit(tipoMaquina);
        tipoMaquina = new Tipomaquina();
    }

    public String editarTipoMaquinaUrl(Tipomaquina tipoMaq) {
        tipoMaquina = tipoMaq;
        return "admaq";
    }

    public void eliminarTipoMaquina(Tipomaquina tipoMaq) {
        tipoMaquinaFacade.remove(tipoMaquina);
    }
// </editor-fold>  
}
