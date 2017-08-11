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
import com.dbsics.util.Mensaje;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@Named(value = "sesion")
@SessionScoped
public class sesion implements Serializable {

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
    
    public sesion() {
    }
     private String url = "";

    // <editor-fold defaultstate="collapsed" desc="Código Sesión">
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cargo = new Cargo();
        rolActual = new Rol();
        rolUsuario = new Rolusuario();
        listaUsuarios = usuarioFacade.findAll();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void credenAdmin() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Administrador:\", \"Usuario: ivduque@hotmail.com   -  clave: 1234\")");
    }

    public void credenPlaneador() {

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Planeador:\", \"Usuario: egbarrera0@hotmail.com   -   clave: 1234\")");

    }

    public void credenGestorMaterial() {

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Gestor Material:\", \"Usuario: cesalbsanchez@hotmail.com   -  clave: 1234\")");

    }

    public void credenGestorProd() {

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Gestor Produccion\", \"Usuario: oscardm@hotmail.com   -  clave: 1234\")");

    }

    public void credenGestorCalidad() {

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Gestor Calidad\", \"Usuario:dscampos19@hotmail.com clave: 1234\")");

    }

    public String validarSesion() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (usuario.getCorreo() != listaUsuarios.get(i).getCorreo()) {
                System.out.println(":: EL usuario no existe ::");
            }
        }
        return "login";
    }

    // obtiene  el objeto que inicio sesion
    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("auth");
        // retorna el objeto sesion o mapeo - va a validaSesion
    }

    public void validaSesion() {
//    si tiene un usuario no hace nada y si tiene lo lleva a la pagina solicitada
// no puede ingresar a una pagina especifica sin iniciar sesion
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            if (getUsuarioSesion() == null) {
                ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml?faces-redict=true");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validarCorreoSesion() {

        if (!usuario.getCorreo().equals(listaUsuarios.get(0).getCorreo())) {
            Mensaje.enviarMensajeErrorGlobal("Error Correo", "El correo no existe en la base de datos o su clave es incorrecta");
        }
    }

    public String logear() {
        Usuario user = new Usuario();
        user = usuarioFacade.UserLogin(usuario);
        String redireccion = "";
        String estado1 = "A";
        String estado2 = "I";

        // auth es el nombre de la variable sesion
        // si usuario es diferente de nulo ;
        validarCorreoSesion();

        if (user != null) {
            // me va apermitir traer instancia como el contexto de lo que genero
//            se crea el usuario sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("auth", user);
            // .getsessionmap - que me traiga la sesion y el ojbeto que va a navegar es el user
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("auth");

            Mensaje.enviarMensajeInformacionGlobal("El usuario", "SE LOGEO CORRECTAMENTE");

            if (usuario.getRolusuarioList().size() > 0) {

                rolActual = usuario.getRolusuarioList().get(0).getIdRol();
                if (rolActual.getIdRol() == 1 && usuario.getEstado().contains(estado1)) {
                    redireccion = "sicspage/modulo1/administrador?faces-redirect=true";
                }
                if (rolActual.getIdRol() == 1 && usuario.getEstado().contains(estado2)) {
                    System.out.println("Usuario inactivo comuniquese con el administrador");
                    redireccion = "userinactivo?faces-redirect=true";

                }
                if (rolActual.getIdRol() == 2 && usuario.getEstado().contains(estado1)) {
                    redireccion = "sicspage/modulo2/modPlaneador?faces-redirect=true";
                }
                if (rolActual.getIdRol() == 2 && usuario.getEstado().contains(estado2)) {
                    System.out.println("Usuario inactivo comuniquese con el administrador");
                    redireccion = "userinactivo?faces-redirect=true";

                }

                if (rolActual.getIdRol() == 3 && usuario.getEstado().contains(estado1)) {

                    redireccion = "sicspage/modulo3/modgesmaterial?faces-redirect=true";
                }
                if (rolActual.getIdRol() == 3 && usuario.getEstado().contains(estado2)) {
                    System.out.println("Usuario inactivo comuniquese con el administrador");
                    redireccion = "userinactivo?faces-redirect=true";

                }
                if (rolActual.getIdRol() == 4 && usuario.getEstado().contains(estado1)) {
                    redireccion = "sicspage/modulo4/modgesproduccion?faces-redirect=true";
                }
                if (rolActual.getIdRol() == 4 && usuario.getEstado().contains(estado2)) {
                    System.out.println("Usuario inactivo comuniquese con el administrador");
                    redireccion = "userinactivo?faces-redirect=true";

                }
                if (rolActual.getIdRol() == 5 && usuario.getEstado().contains(estado1)) {
                    redireccion = "sicspage/modulo5/modgescalidad?faces-redirect=true";
                }
                if (rolActual.getIdRol() == 5 && usuario.getEstado().contains(estado2)) {
                    System.out.println("Usuario inactivo comuniquese con el administrador");
                    redireccion = "userinactivo?faces-redirect=true";

                }
                if (rolActual.getIdRol() == 0 && usuario.getEstado().contains("")) {
                    Mensaje.enviarMensajeInformacionGlobal("El usuario", "no tiene ningun rol");
                    System.out.println("no tiene ningun rol");
                    redireccion = "login?faces-redirect=true";

                }
            } else {
                //faces redirect true lo que hace es actualizar la direccion en url

                Mensaje.enviarMensajeErrorGlobal("El usuario", "no tiene ningun rol");
                redireccion = "login?faces-redirect=true";
            }

        } else {
            // redireccionar al login sino se pudo logear
            redireccion = "login";
        }
        return redireccion;
    }

    public String cambiarRol(Rol rol) {
        this.rolActual = rol;
        System.out.println(rol.getRol());
        if (this.rolActual.getIdRol() == 1) {
            return "administrador?faces-redirect=true";
        } else if (this.rolActual.getIdRol() == 2) {

//            url= FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//modulo2//modPlaneador.xhtml");
            return "sicspage/modulo2/modPlaneador?faces-redirect=true";
//            return url;
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

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        String direccionar = "";
        usuario = null;
        rolActual = null;
        if (rolActual == null) {
            direccionar = "../login";
            System.out.println(":: Cerro sesion exitosamente ::");
        }
    }

    // </editor-fold>
}
