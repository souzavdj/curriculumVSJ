package br.com.vsj.curriculumvsj.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Classe DAO genérica para persistir dados gerais no Banco de Dados. 
 * @author vinicius
 * @version  1.0
 * @param <T> Tipo da classe
 */
public class GenericDAO<T> {

    protected EntityManager manager;
    protected Class<T> t;

    GenericDAO(Class<T> t, EntityManager manager) {
        this.t = t;
        this.manager = manager;
    }

    public List<T> selectAll() {
        List<T> lista = manager.createQuery("from " + t.getName()).getResultList();
        return lista;
    }

    public T select(Integer id) {
        return manager.find(t, id);
    }

    public void insert(T entidade) {
        manager.persist(entidade);
    }

    public void remove(T entidade) {
        manager.remove(entidade);
    }

    public void update(T entidade) {
        manager.merge(entidade);
    }

}
