/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Formula;
import com.dbsics.entities.Stockmaterial;
import com.dbsics.entities.Subproceso;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.FormulaFacade;
import com.dbsics.facade.StockmaterialFacade;
import com.dbsics.facade.SubprocesoFacade;
import com.dbsics.facade.UsuarioFacade;
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
@Named(value = "controllerFormulaMaterial")
@SessionScoped
public class controllerFormulaMaterial implements Serializable {

    @EJB
    FormulaFacade formulaFacade;
    Formula formula;
    List<Formula> listaFormulas;
    
    @EJB
    StockmaterialFacade stockMaterialFacade;
    private Stockmaterial stockMaterial;

    @EJB
    SubprocesoFacade subPocesoFacade;
    private Subproceso subProceso;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    
    public controllerFormulaMaterial() {
    }
     // <editor-fold defaultstate="collapsed" desc="Código Formula">
    
    @PostConstruct
    public void init(){
        formula = new Formula();
        listaFormulas = formulaFacade.findAll();
        stockMaterial = new Stockmaterial();
        usuario = new Usuario();
        subProceso = new Subproceso();
    }
    public  List<Formula> listarFormulas(){
        return formulaFacade.findAll();
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public List<Formula> getListaFormulas() {
        return listaFormulas;
    }

    public void setListaFormulas(List<Formula> listaFormulas) {
        this.listaFormulas = listaFormulas;
    }

    public Stockmaterial getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(Stockmaterial stockMaterial) {
        this.stockMaterial = stockMaterial;
    }

    public Subproceso getSubProceso() {
        return subProceso;
    }

    public void setSubProceso(Subproceso subProceso) {
        this.subProceso = subProceso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nueva Fórmula!\",\n"
                + "  text: \"La Fórmula " + formula.getFormula() + " fue creada exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }
    public void crearFormula() {
        try {
            formula.setIdformula(null);
            formula.setCodStockMaterial(stockMaterial);
            formula.setCodSubProceso(subProceso);
            formula.setUsuarioRegistro(usuarioFacade.find(usuario.getIdUsuario()));
            formulaFacade.create(formula);
            alertaCreacion();
            formula = new Formula();
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal(":: Error: El material ya existe en la Fórmula::", "");
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

    public void editarFormula() {
        alertaModificar();
        formulaFacade.edit(formula);
        formula = new Formula();
    }

    public String editarFormulaUrl(Formula formul) {
        this.formula = formul;
        return "modaminuser";
    }
    // </editor-fold>
}
