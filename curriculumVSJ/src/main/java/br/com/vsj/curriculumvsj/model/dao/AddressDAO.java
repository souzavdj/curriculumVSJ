/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.dao;

import br.com.vsj.curriculumvsj.model.entity.Address;

/**
 * Classe DAO para persistir os Endereços no Banco de Dados.
 * @author vinicius
 * @version 1.0
 */
public class AddressDAO extends GenericDAO<Address>{
    
    public AddressDAO() {
        super(Address.class, PersistenceManager.getEntityManager());
    }
    
}
