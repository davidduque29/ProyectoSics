/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Cargo;
import com.dbsics.entities.Rol;
import com.dbsics.entities.Rolusuario;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.CargoFacade;
import com.dbsics.facade.RolFacade;
import com.dbsics.facade.RolusuarioFacade;
import com.dbsics.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "sesionCambiaRol")
@SessionScoped
public class sesionCambiaRol implements Serializable {

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    @EJB
    RolFacade rolFacade;
    private Rol rolActual;

    @EJB
    RolusuarioFacade rolUsuarioFacade;
    private Rolusuario rolUsuario;

    @EJB
    CargoFacade cargoFacade;
    private Cargo cargo;

    public sesionCambiaRol() {
    }
    String url = "";

    // <editor-fold defaultstate="collapsed" desc="Código Sesión">
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cargo = new Cargo();
        rolActual = new Rol();
        rolUsuario = new Rolusuario();
        listaUsuarios = usuarioFacade.findAll();
    }

    public String cambiarRol(Rol rol) {
        this.rolActual = rol;
        System.out.println(rol.getRol());
        if (this.rolActual.getIdRol() == 1) {
            return "administrador?faces-redirect=true";
        } else if (this.rolActual.getIdRol() == 2) {

            url = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//modulo2//modPlaneador.xhtml");

            return url;
        } else if (this.rolActual.getIdRol() == 3) {
            return "modgesmaterial?faces-redirect=true";
        } else if (this.rolActual.getIdRol() == 4) {
            return "modgesproduccion?faces-redirect=true";
        } else if (this.rolActual.getIdRol() == 5) {
            return "modgescalidad?faces-redirect=true";
        } else {
            return "login?faces-redirect=true";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Rol getRolActual() {
        return rolActual;
    }

    public void setRolActual(Rol rolActual) {
        this.rolActual = rolActual;
    }

    public Rolusuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rolusuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
