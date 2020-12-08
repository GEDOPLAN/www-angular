package de.gedoplan.ged.angular.www.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
public class EntityManagerProducer {
    @PersistenceContext(unitName = "book-demo")
    @Produces
    private EntityManager em;
}
