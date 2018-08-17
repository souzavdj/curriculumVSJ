/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.control;

import br.com.vsj.curriculumvsj.model.dao.GenericDAO;
import br.com.vsj.curriculumvsj.model.dao.PersistenceManager;
import br.com.vsj.curriculumvsj.model.entity.Phone;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Classe de Controle para os Telefones.
 * @author vinicius
 * @version 1.0
 */
public class PhoneController {

    public static List<Phone> listAllPhones() {
        GenericDAO<Phone> PhoneDAO = PersistenceManager.createGenericDAO(Phone.class);
        return PhoneDAO.selectAll();
    }

    public static Phone findPhone(Phone phone) {
        GenericDAO<Phone> phoneDAO = PersistenceManager.createGenericDAO(Phone.class);
        return phoneDAO.select(phone.getId());
    }

    public static void insertPhone(Phone phone) {
        GenericDAO<Phone> phoneDAO = PersistenceManager.createGenericDAO(Phone.class);
        PersistenceManager.getTransaction().begin();
        try {
            phoneDAO.insert(phone);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(PhoneController.class);
            lg.error("Exceção ao tentar incluir Telefone. ", e);
            PersistenceManager.getTransaction().rollback();
        }
    }

    public static void updatePhone(Phone phone) {
        GenericDAO<Phone> phoneDAO = PersistenceManager.createGenericDAO(Phone.class);

        try {
            PersistenceManager.getTransaction().begin();
            phoneDAO.update(phone);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(Phone.class);
            lg.error("Exceção ao tentar alterar Telefone. ", e);
            PersistenceManager.getTransaction().rollback();
        }

    }
}
