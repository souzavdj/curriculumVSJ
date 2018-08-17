/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.control;

import br.com.vsj.curriculumvsj.model.dao.GenericDAO;
import br.com.vsj.curriculumvsj.model.dao.PersistenceManager;
import br.com.vsj.curriculumvsj.model.entity.Institution;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Classe de Controle para as Instituições.
 * @author vinicius
 * @version 1.0
 */
public class InstitutionController {
    public static List<Institution> listAllInstitutions() {
        GenericDAO<Institution> institutionDAO = PersistenceManager.createGenericDAO(Institution.class);
        return institutionDAO.selectAll();
    }

    public static Institution findInstitution(Institution institution) {
        GenericDAO<Institution> institutionDAO = PersistenceManager.createGenericDAO(Institution.class);
        return institutionDAO.select(institution.getId());
    }

    public static void insertInstitution(Institution institution) {
        GenericDAO<Institution> institutionDAO = PersistenceManager.createGenericDAO(Institution.class);
        PersistenceManager.getTransaction().begin();
        try {
            institutionDAO.insert(institution);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(InstitutionController.class);
            lg.error("Exceção ao tentar incluir Instituição. ", e);
            PersistenceManager.getTransaction().rollback();
        }
    }

    public static void updateInstitution(Institution institution) {
        GenericDAO<Institution> institutionDAO = PersistenceManager.createGenericDAO(Institution.class);

        try {
            PersistenceManager.getTransaction().begin();
            institutionDAO.update(institution);
            PersistenceManager.getTransaction().commit();
        } catch (Exception e) {
            Logger lg = Logger.getLogger(Institution.class);
            lg.error("Exceção ao tentar alterar Instituição. ", e);
            PersistenceManager.getTransaction().rollback();
        }

    }
    
}
