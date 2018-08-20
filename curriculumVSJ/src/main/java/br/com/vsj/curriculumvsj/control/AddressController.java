/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.control;

import br.com.vsj.curriculumvsj.model.dao.GenericDAO;
import br.com.vsj.curriculumvsj.model.dao.PersistenceManager;
import br.com.vsj.curriculumvsj.model.entity.Address;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Classe de Controle para os Endereços.
 * @author vinicius
 * @version 1.0
 */
public class AddressController {
    
    public static List<Address> listAllAddresss() {
        GenericDAO<Address> addressDAO = PersistenceManager.createGenericDAO(Address.class);
        return addressDAO.selectAll();
    }

    public static Address findAddress(Address address) {
        GenericDAO<Address> addressDAO = PersistenceManager.createGenericDAO(Address.class);
        return addressDAO.select(address.getId());
    }

    public static void insertAddress(Address address) {
        GenericDAO<Address> addressDAO = PersistenceManager.createGenericDAO(Address.class);
        try {
            PersistenceManager.getTransaction().begin();
            addressDAO.insert(address);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(AddressController.class);
            lg.error("Exceção ao tentar incluir Endereço. ", e);
            PersistenceManager.getTransaction().rollback();
            throw e;
        }
    }

    public static void updateAddress(Address address) {
        GenericDAO<Address> addressDAO = PersistenceManager.createGenericDAO(Address.class);

        try {
            PersistenceManager.getTransaction().begin();
            addressDAO.update(address);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(Address.class);
            lg.error("Exceção ao tentar alterar Endereço. ", e);
            PersistenceManager.getTransaction().rollback();
            throw e;
        }

    }
}
