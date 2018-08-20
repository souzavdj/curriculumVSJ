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

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("curriculumVSJPU");
    private static EntityManager manager = factory.createEntityManager();

    public static EntityManager getEntityManager() {
        return manager;
    }

    public static <T> GenericDAO<T> createGenericDAO(Class<T> t) {
        return new GenericDAO<T>(t, manager);
    }

    public static EntityTransaction getTransaction() {
        return manager.getTransaction();
    }

}
