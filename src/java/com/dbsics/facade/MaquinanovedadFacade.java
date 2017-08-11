/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.facade;

import com.dbsics.entities.Maquinanovedad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santi Duque
 */
@Stateless
public class MaquinanovedadFacade extends AbstractFacade<Maquinanovedad> {

    @PersistenceContext(unitName = "sics2017PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaquinanovedadFacade() {
        super(Maquinanovedad.class);
    }
    
}
