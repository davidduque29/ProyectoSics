/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.facade;

import com.dbsics.entities.Usuario;
import com.dbsics.util.Mensaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santi Duque
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "sics2017PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
   public Usuario UserLogin(Usuario usuario) {
        Usuario user = null;
        try {
            /* String qlString= "select u from usuario u where u.email=:email and u.clave= :clave";*/
            javax.persistence.Query q = em.createQuery("select u from Usuario u where u.correo=:correo and u.clave= :clave");
            // Query q = em.createNativeQuery("consulta tal cual sql"); para cifrados
            q.setParameter("correo", usuario.getCorreo());
            q.setParameter("clave", usuario.getClave());

            java.util.List<Usuario> lista = q.getResultList();

            if (!lista.isEmpty()) {
                // recogemos el primer resultado(solo llega 1 registro)
                user = lista.get(0);
            }
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("El usuario", "No existe");

        }
        return user;
    }

    public List<Usuario> ValidarCorreo() {
        Usuario user = null;
        javax.persistence.Query q = em.createNativeQuery("select correo from usuario");

        java.util.List<Usuario> listaCorreo = q.getResultList();
        user = listaCorreo.get(0);

        return listaCorreo;
    }

    public String cargaDatos(String archivo, String tabla) {
        Query conu = em.createNativeQuery("LOAD DATA INFILE '" + archivo + "'"
                + " INTO TABLE " + tabla + " FIELDS TERMINATED BY \';\'"
        );
        int resultado = conu.executeUpdate();
        String mensaje = resultado + "filas afectadas";
        return mensaje;
    }

    public Usuario validaUsuario(Usuario usuario) {
        Usuario user = null;
        try {
            /* String qlString= "select u from usuario u where u.email=:email and u.clave= :clave";*/
            javax.persistence.Query q = em.createQuery("select u from Usuario u where u.correo=:correo and u.idUssuario= :idUssuario");
            // Query q = em.createNativeQuery("consulta tal cual sql"); para cifrados
            q.setParameter("correo", usuario.getCorreo());
            q.setParameter("idUssuario", usuario.getIdUsuario());

            java.util.List<Usuario> lista = q.getResultList();

            if (!lista.isEmpty()) {
                // recogemos el primer resultado(solo llega 1 registro)
                user = lista.get(0);
            }
        } catch (Exception e) {
            Mensaje.enviarMensajeErrorGlobal("El usuario", "No existe");

        }
        return user;
    }
}

