/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Medicina;

/**
 *
 * @author Angie
 */
@Stateless
public class MedicinaFacade extends AbstractFacade<Medicina> {

    @PersistenceContext(unitName = "HospitalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicinaFacade() {
        super(Medicina.class);
    }
    
}
