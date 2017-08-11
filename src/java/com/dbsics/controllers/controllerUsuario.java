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
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Santi Duque
 */
@Named(value = "controllerUsuario")
@SessionScoped
public class controllerUsuario implements Serializable {

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
    private List<Cargo> listaCargos;

    // Variables carga de archivos
    private Part file;
    private Part fileFoto;
    private String nombre;
    private String nombreFoto;
    private String pathReal;
    private String pathRealFoto;
    private String path;
    private String pathFoto;
    private String clave2;

    JasperPrint jasperPrint;

    public controllerUsuario() {
    }
    private String ruta;

    // <editor-fold defaultstate="collapsed" desc="Código Usuario"> 
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cargo = new Cargo();
        rolActual = new Rol();
        rolUsuario = new Rolusuario();
        listaUsuarios = usuarioFacade.findAll();
        listaCargos = cargoFacade.findAll();
    }

    public void submit() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal(\"Good job!\", \"You clicked the button!\", \"success\")");
    }

    public void initUsuario() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaUsuarios);
        jasperPrint = JasperFillManager.fillReport(ruta, new HashMap(), beanCollectionDataSource);
//      jasperPrint = JasperFillManager.fillReport("C:\\Users\\ivandavid\\Desktop\\SicsProject\\backup\\sics\\web\\sicspage\\reporte\\reporteusuarios.jasper", new HashMap(),beanCollectionDataSource);

    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//reporte//reporteusuarios.jasper");
        initUsuario();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte_usuarios.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

    }

    public List<Usuario> listarUsuarios() {
        return usuarioFacade.findAll();
    }

    public Part getFileFoto() {
        return fileFoto;
    }

    public void setFileFoto(Part fileFoto) {
        this.fileFoto = fileFoto;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getPathRealFoto() {
        return pathRealFoto;
    }

    public void setPathRealFoto(String pathRealFoto) {
        this.pathRealFoto = pathRealFoto;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
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

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void alertaCreacion2() {
        RequestContext context = RequestContext.getCurrentInstance();
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//resources//imgs//logo.jpg");
        context.execute("swal({\n"
                + "  title: \"Sweet!\",\n"
                + "  text: \"Here's a custom image.\",\n"
                + "  imageUrl: \"  ../../resources/imgs/logomessage.jpg  \"\n"
                + "});");
    }
// carga de foto

    public void uploadFoto() {
        pathFoto = FacesContext.getCurrentInstance().getExternalContext().getRealPath("archivos");
        //ruta del archivo del pc
        pathFoto = pathFoto.substring(0, pathFoto.indexOf("\\build"));
        pathFoto = pathFoto + "\\web\\archivos\\";
        try {
            //nombre del archivo
            this.nombreFoto = fileFoto.getSubmittedFileName();
            //enlace del archivo desde el naevgador
            //pathReal = "/sics/Archivos/" + nombre;
            pathFoto = pathFoto + this.nombreFoto;

            InputStream in = fileFoto.getInputStream();

            byte[] data = new byte[in.available()];
            in.read(data);
            File archivo = new File(pathFoto);
            FileOutputStream out = new FileOutputStream(archivo);
            out.write(data);
            in.close();
            out.close();

//            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//            user.setFotoCedula(pathReal);
//            usuarioFacade.edit(user);
            pathFoto = pathFoto.replace("\\", "\\\\");

            System.out.println(pathFoto + nombreFoto);
            //ciudadesFacade.cargaDatos(path, "ciudades");
            //archivo.delete();        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alertaCreacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        ruta = "../../resources/imgs/logomessage.jpg";
        context.execute("swal({\n"
                + "  title: \"Nuevo Usuario!\",\n"
                + "  text: \"El usuario " + usuario.getCorreo() + " fue creado exitosamente .\",\n"
                + "  imageUrl: \"  " + ruta + "  \"\n"
                + "});");
    }

    public void registrarUsuario() {

        Calendar c = Calendar.getInstance();
        Date fecha = c.getTime();
        try {
//            if (usuario.getClave()!= getClave2()) {
//                Mensaje.enviarMensajeErrorGlobal("Error Claves", "Ambas claves no coinciden");
//            }else{}

            for (int i = 0; i < listaUsuarios.size(); i++) {

                if (Objects.equals(usuario.getIdUsuario(), listaUsuarios.get(i).getIdUsuario().toString())) {

                } else if (usuario.getCorreo().equals(listaUsuarios.get(i).getCorreo())) {
                    Mensaje.enviarMensajeInformacionGlobal("Error correo", ":: El correo ya existe ::");
                } else {
                }
            }// fin for ../../archivos
            ruta = "..\\..\\archivos\\";
            setFile(fileFoto); // se envia el fileFoto que se captura en la vista
            uploadFoto();
            String Foto = fileFoto.getSubmittedFileName(); // Con el .getSubmittedFileName() se trae el nombre
            usuario.setFotoCedula(ruta + Foto);
            usuario.setCodCargo(cargoFacade.find(cargo.getIdCargo()));
            usuario.setFechaModificacion(fecha);
            usuarioFacade.create(usuario);
//                   for (int i = 0; i < listaUsuarios.size(); i++) {
//                        Mailer.send(listaUsuarios.get(i).getCorreo(), "Creacion nuevo usuario",
//                        "Usuario creado: " + usuario.getPmrNombre() + " " + usuario.getPmrApellido() + "\n"
//                        + "Cedula: " + usuario.getIdUsuario()+"\n"+"Correo: "+usuario.getCorreo());
//            }
            alertaCreacion();
            usuario = new Usuario();
            // idCliente es id en la vista ejemplo(div id='txtCreado')

//            Mensaje.enviarMensajeInformacionGlobal("Usuario creado", ":: El usuario ha sido creado exitosamente ::");
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("Error Usuario", "El usuario No pudo ser creado porque ya existe un usuario  \n"
                    + "  con los datos cedula o correo en la base de datos");
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

    public void editarUsuario() {
        alertaModificar();
        usuarioFacade.edit(usuario);
        usuario = new Usuario();
    }

    public String editarUsuarioUrl(Usuario user) {
        usuario = user;
        return "editarusuario";
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioFacade.remove(usuario);
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos Adicionales"> 
    public void upload() {
        path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("archivos");
        //ruta del archivo del pc
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\archivos\\";
        try {
            //nombre del archivo
            this.nombre = file.getSubmittedFileName();
            //enlace del archivo desde el naevgador
            //pathReal = "/sics/Archivos/" + nombre;
            path = path + this.nombre;

            InputStream in = file.getInputStream();

            byte[] data = new byte[in.available()];
            in.read(data);
            File archivo = new File(path);
            FileOutputStream out = new FileOutputStream(archivo);
            out.write(data);
            in.close();
            out.close();

//            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//            user.setFotoCedula(pathReal);
//            usuarioFacade.edit(user);
            path = path.replace("\\", "\\\\");

            System.out.println(path + nombre);

            //ciudadesFacade.cargaDatos(path, "ciudades");
            //archivo.delete();        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String cargarArchivoCSV() throws IOException {
        setFile(file);
        upload();
        String path = getPath();
        String tabla = "usuario";
        String resultado = usuarioFacade.cargaDatos(path, tabla);
        return "crearusuario";
    }

    public void verificarClaveAlert() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" sweetAlert(\"Oops...\", \"¡¡Datos no validos!!\", \"error\");");
    }

    public String validarClaveUrl() {
        String redireccion = "";

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (Objects.equals(usuario.getIdUsuario(), listarUsuarios().get(i).getIdUsuario())) {
                redireccion = "observacion";

            } else {
            }
        }

        verificarClaveAlert();
        redireccion = "login";

        return redireccion;
    }
    // </editor-fold>
}
