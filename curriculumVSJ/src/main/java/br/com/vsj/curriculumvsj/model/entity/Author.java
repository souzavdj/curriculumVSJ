/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.entity;

/**
 * Classe modelo para os Autores
 * @author vinicius
 * @version 1.1
 */
public class Author {
    
    private String name;
    
    private Institution institution;
    
    private String email;
    
    private String phone;
    
    private Address address;

    public Author() {
    }

    public Author(String name, Institution institution, String email, String phone, Address address) {
        this.name = name;
        this.institution = institution;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
