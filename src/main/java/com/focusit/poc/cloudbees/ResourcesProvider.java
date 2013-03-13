/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.focusit.poc.cloudbees;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Julien
 */
public class ResourcesProvider {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
