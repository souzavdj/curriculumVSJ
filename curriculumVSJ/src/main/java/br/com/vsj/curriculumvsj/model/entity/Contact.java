/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.entity;

import java.util.List;

/**
 * Classe modelo para o contato.
 * @author vinicius
 * @version 1.1
 */
public class Contact {
    
    private String name;
    
    private String email;
    
    private List<String> phones;
    
    private List<Institution> instituions;

    public Contact() {
    }

    public Contact(String name, String email, List<String> phones, List<Institution> instituions) {
        this.name = name;
        this.email = email;
        this.phones = phones;
        this.instituions = instituions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<Institution> getInstituions() {
        return instituions;
    }

    public void setInstituions(List<Institution> instituions) {
        this.instituions = instituions;
    }
    
    
}
