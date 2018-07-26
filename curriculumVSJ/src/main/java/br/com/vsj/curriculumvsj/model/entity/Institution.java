/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.entity;

import java.util.List;

/**
 * Classe modelo para as instituições.
 * @author vinicius
 * @version 1.0
 */
public class Institution {
    
    private String name;
    
    private String department;
    
    private String email;
    
    private Address address;
    
    private List<String> phones;

    public Institution() {
    }

    public Institution(String name, String department, String email, Address address, List<String> phones) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.address = address;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
    
}
