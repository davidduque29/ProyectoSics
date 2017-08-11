/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerImagen")
@SessionScoped
public class controllerImagen implements Serializable {

    /**
     * Creates a new instance of controllerImagen
     */
    public controllerImagen() {
    }
    private String ruta;
    
    public void init(){
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public void imagenPdfUrl(){
        
       ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//resources//imgs//iconos//pdf.png");
    }
}
