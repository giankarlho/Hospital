/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Ubigeo;

/**
 *
 * @author Angie
 */
@Stateless
public class UbigeoFacade extends AbstractFacade<Ubigeo> {

    @PersistenceContext(unitName = "HospitalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbigeoFacade() {
        super(Ubigeo.class);
    }
    
}
