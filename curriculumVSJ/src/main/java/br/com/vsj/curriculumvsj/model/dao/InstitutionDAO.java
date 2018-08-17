/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.dao;

import br.com.vsj.curriculumvsj.model.entity.Institution;

/**
 * Classe DAO para persistir as Instituições no Banco de Dados
 * @author vinicius
 * @version 1.0
 */
public class InstitutionDAO extends GenericDAO<Institution>{
    
    public InstitutionDAO() {
        super(Institution.class, PersistenceManager.getEntityManager());
    }
}
