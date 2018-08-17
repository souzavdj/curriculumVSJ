/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.dao;

import br.com.vsj.curriculumvsj.model.entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe DAO para persistir os telefones no Banco de Dados.
 *
 * @author vinicius
 * @version 1.0
 */
public class PhoneDAO extends GenericDAO<Phone>{

    public PhoneDAO() {
        super(Phone.class, PersistenceManager.getEntityManager());
    }

}
