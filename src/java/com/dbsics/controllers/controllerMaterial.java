/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Stockmaterial;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.StockmaterialFacade;
import com.dbsics.facade.UsuarioFacade;
import com.dbsics.util.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javafx.scene.paint.Material;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerMaterial")
@SessionScoped
public class controllerMaterial implements Serializable {

    @EJB
    StockmaterialFacade MaterialFacade;
    private Stockmaterial material;
    private List<Stockmaterial> listaMateriales;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public controllerMaterial() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Material"> 

    @PostConstruct
    public void initMaterial() {
        usuario = new Usuario();
        material = new Stockmaterial();
        listaMateriales = MaterialFacade.findAll();
    }

    public List<Stockmaterial> listarMateriales() {
        return MaterialFacade.findAll();
    }

    public Stockmaterial getMaterial() {
        return material;
    }

    public void setMaterial(Stockmaterial material) {
        this.material = material;
    }

    public List<Stockmaterial> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Stockmaterial> listaMateriales) {
        this.listaMateriales = listaMateriales;
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
                + "  title: \"Nuevo Material!\",\n"
                + "  text: \"El Material " + material.getMaterial() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void crearMaterial() {
        try {
            material.setIdStockMaterial(null);
            material.setUsuarioRegistro(usuario);
            alertaCreacion();
            MaterialFacade.create(this.material);
            material = new Stockmaterial();

        } catch (Exception e) {
            Mensaje.enviarMensajeInformacionGlobal(":: Error: El código de Barras del Material ya existe ::", "");
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

    public void editarMaterial() {
        MaterialFacade.edit(material);
        alertaModificar();
        material = new Stockmaterial();
    }

    public String editarMaterialUrl(Stockmaterial material) {
        this.material = material;
        return "modadminuser";
    }

    public void eliminarMaterial(Stockmaterial material) {
        MaterialFacade.remove(material);
    }
    // </editor-fold >
}
