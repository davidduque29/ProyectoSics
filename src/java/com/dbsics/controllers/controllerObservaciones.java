/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Observaciones;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.ObservacionesFacade;
import com.dbsics.facade.UsuarioFacade;
import com.dbsics.util.Mensaje;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerObservaciones")
@SessionScoped
public class controllerObservaciones implements Serializable {

    @EJB
    ObservacionesFacade observacionFacade;
    private Observaciones observacion;
    private List<Observaciones> listaObservaciones;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    public controllerObservaciones() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Observaciones">
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        observacion = new Observaciones();
        listaUsuarios = usuarioFacade.findAll();
        listaObservaciones = observacionFacade.findAll();
    }

    public List<Observaciones> listarObservaciones() {
        return observacionFacade.findAll();
    }

    public Observaciones getObservacion() {
        return observacion;
    }

    public void setObservacion(Observaciones observacion) {
        this.observacion = observacion;
    }

    public List<Observaciones> getListaObservaciones() {
        return listaObservaciones;
    }

    public void setListaObservaciones(List<Observaciones> listaObservaciones) {
        this.listaObservaciones = listaObservaciones;
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

    public void verificarClaveAlert() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" sweetAlert(\"Oops...\", \"¡¡Datos no validos!!\", \"error\");");
    }

 public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nueva Observación!\",\n"
                + "  text: \"La Observación " + observacion.getDescripcion() + " fue creada exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void verificarObservacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal({\n"
                + "  title: \"¿Esta seguro de Enviar?\",\n"
                + "  text: \"No podrá deshacer los cambios realizados!\",\n"
                + "  type: \"warning\",\n"
                + "  showCancelButton: true,\n"
                + "  confirmButtonColor: \"#DD6B55\",\n"
                + "  confirmButtonText: \"Si, Modificar!\",\n"
                + "  closeOnConfirm: false\n"
                + "},\n"
                + "function(){\n"
                + "  swal(\"Modificado!\", \"Su solicitud fue procesada.\", \"success\");\n"
                + "});");
    }

    
     public String crearObservacionClave() throws UnsupportedEncodingException {
        try {
            observacion.setCodUsuario(usuarioFacade.find(usuario.getIdUsuario()));
            observacionFacade.create(observacion);
            // MENSAJE PARA EL ADMINISTRADOR
//            MailerClave.send("ivduque@hotmail.com", " ¡¡Credenciales!! ", "Señor Administrador:\n"
//                    + "El Usuario: " + observacion.getCodUsuario().getCorreo() + " tiene la siguiente solicitud con"
//                    + " la siguiente descripcion: \n"
//                    + "*" + observacion.getDescripcion());
            alertaCreacion();
            observacion = new Observaciones();
            System.out.println("Correo enviado con exito");
        } catch (Exception e) {
             Mensaje.enviarMensajeErrorGlobal(":: Error: Datos ::", "");
        }

        return "confirmacion";
    }

    public void confirmarAlert() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal({\n"
                + "  title: \"Su solicitud se ha completado!\",\n"
                + "  text: \"Mensaje exitoso.\",\n"
                + "  timer: 1800,\n"
                + "  showConfirmButton: false\n"
                + "});");
    }

    public String confirmacionCorreo() throws UnsupportedEncodingException {
        observacion.setCodUsuario(usuarioFacade.find(usuario.getIdUsuario()));
        confirmarAlert();
//        MailerClave.send(observacion.getCodUsuario().getCorreo(), ":: Credenciales ::", "Señor: \n"
//                + "" + observacion.getCodUsuario().getPmrNombre() + observacion.getCodUsuario().getPmrApellido() + "\n"
//                + "Su solicitud fue enviada con exito, por favor espere la respuesta del administrador.");
        return "login";
    }

    public String responderSolicitud() throws UnsupportedEncodingException {
        try {
            observacion.setIdObservaciones(null);
            observacion.setCodUsuario(usuarioFacade.find(usuario.getIdUsuario()));
            observacionFacade.create(observacion);
            // MENSAJE PARA EL ADMINISTRADOR
//            MailerClave.send(observacion.getCodUsuario().getCorreo(), " ¡¡Credenciales!! ", "Señor:\n"
//                    + observacion.getCodUsuario().getPmrNombre() + " " + observacion.getCodUsuario().getPmrApellido()
//                    + " * Asunto: " + observacion.getDescripcion());
            alertaCreacion();
            observacion = new Observaciones();
            System.out.println("Correo enviado con exito");
        } catch (Exception e) {
             Mensaje.enviarMensajeErrorGlobal(":: Error: Datos ::", "");
        }

        return "crearobservacion";
    }

    public String editarObservacionUrl(Observaciones observacion) {
        this.observacion = observacion;
        return "editarobservacion";
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

    public void editarObservacion() {
        alertaModificar();
        observacionFacade.edit(observacion);
        observacion = new Observaciones();
    }
    // </editor-fold>
}
