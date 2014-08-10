package com.phoenicia.fearfactor.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Noel
 */
public class BaseHibernateRepository {
    
    protected EntityManager entityManager;
 
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
}
