/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.facade;

import com.dbsics.entities.Stockmaterial;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santi Duque
 */
@Stateless
public class StockmaterialFacade extends AbstractFacade<Stockmaterial> {

    @PersistenceContext(unitName = "sics2017PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockmaterialFacade() {
        super(Stockmaterial.class);
    }
   public java.util.List<Object[]> reporteSobrante() {
        javax.persistence.Query consulta = em.createNativeQuery("select  st.material, sum(so.cantidad) as cantidad\n"
                + "from 	sobrante as so inner join \n"
                + "		stockmaterial as st on st.idStockMaterial = so.codStockMaterial \n"
                + "group by so.fechaCreacion");
//        + "where so.fechaCreacion between '"+fechaInicial+"'  and '"+fechaFinal+"' group by so.fechaCreacion");

        // + "where so.fechaCreacion between '"+ fechaInicial+ "' and '"+ fechaFinal+"'");
        // "where so.fechaCreacion between '2017-01-01'  and '2017-05-30'\n"
        // Se crea una lista de objetos
        java.util.List<Object[]> listaSobrantes = new ArrayList<>();
        // Se obtienen los datos que trae la variable consulta con .getResultList
        listaSobrantes = consulta.getResultList();
        System.out.println(listaSobrantes);

        return listaSobrantes;// se retorna la lista de objetos  - ir al controllerGraficos
    }

}

