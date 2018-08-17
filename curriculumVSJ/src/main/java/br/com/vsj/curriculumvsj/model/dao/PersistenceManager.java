package br.com.vsj.curriculumvsj.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe para Implementação do encapsulamento da persistência.
 *
 * @author vinicius
 * @version 1.0
 */
public class PersistenceManager {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("curriculumVSJPU");
    private static final EntityManager MANAGER = FACTORY.createEntityManager();

    public static EntityManager getEntityManager() {
        return MANAGER;
    }

    public static <T> GenericDAO<T> createGenericDAO(Class<T> t) {
        return new GenericDAO<T>(t, MANAGER);
    }

    public static EntityTransaction getTransaction() {
        return MANAGER.getTransaction();
    }

}
