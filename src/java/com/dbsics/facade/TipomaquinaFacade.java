/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.facade;

import com.dbsics.entities.Tipomaquina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santi Duque
 */
@Stateless
public class TipomaquinaFacade extends AbstractFacade<Tipomaquina> {

    @PersistenceContext(unitName = "sics2017PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipomaquinaFacade() {
        super(Tipomaquina.class);
    }
    
}
