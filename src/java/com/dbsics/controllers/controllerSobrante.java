/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Produccion;
import com.dbsics.entities.Sobrante;
import com.dbsics.entities.Stockmaterial;
import com.dbsics.facade.ProduccionFacade;
import com.dbsics.facade.SobranteFacade;
import com.dbsics.facade.StockmaterialFacade;
import com.dbsics.util.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerSobrante")
@SessionScoped
public class controllerSobrante implements Serializable {

    @EJB
    SobranteFacade sobrantefacade;
    private Sobrante sobrante;
    private List<Sobrante> listarsobrante;

    @EJB
    StockmaterialFacade stockmaterialfacade;
    private Stockmaterial stockmaterial;

    @EJB
    ProduccionFacade produccionfacade;
    private Produccion produccion;

    public controllerSobrante() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Sobrante">
    @PostConstruct
    public void initSobrante() {
        sobrante = new Sobrante();
        stockmaterial = new Stockmaterial();
        produccion = new Produccion();
        listarsobrante = sobrantefacade.findAll();
    }

    public List<Sobrante> listarSobrante() {
        return sobrantefacade.findAll();
    }

    public Sobrante getSobrante() {
        return sobrante;
    }

    public void setSobrante(Sobrante sobrante) {
        this.sobrante = sobrante;
    }

    public List<Sobrante> getListarsobrante() {
        return listarsobrante;
    }

    public void setListarsobrante(List<Sobrante> listarsobrante) {
        this.listarsobrante = listarsobrante;
    }

    public Stockmaterial getStockmaterial() {
        return stockmaterial;
    }

    public void setStockmaterial(Stockmaterial stockmaterial) {
        this.stockmaterial = stockmaterial;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Sobrante!\",\n"
                + "  text: \"El Sobrante del material " + sobrante.getCodStockMaterial().getMaterial() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearSobrante() {
        try {
            Calendar c = Calendar.getInstance();
            Date fecha = c.getTime();
            sobrante.setIdSobrante(null);
            sobrante.setFechaCreacion(fecha);
            sobrante.setCodProduccion(produccion);
            sobrante.setCodStockMaterial(stockmaterial);
            alertaCreacion();
            sobrantefacade.create(this.sobrante);
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: Sobrante ya existe ::", "");
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

    public void editarSobrante() {
        sobrante.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
        sobrante.setCodStockMaterial(stockmaterialfacade.find(stockmaterial.getIdStockMaterial()));
        alertaModificar();
        sobrantefacade.edit(sobrante);
        sobrante = new Sobrante();
    }

    public String editarSobranteUrl(Sobrante sobra) {
        this.sobrante = sobra;
        return "editarSobrante";

    }

    public void eliminarSobrante(Sobrante sobrante) {
        sobrantefacade.remove(sobrante);
    }
    // </editor-fold>
}
