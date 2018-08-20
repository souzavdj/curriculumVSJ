/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe modelo para as instituições.
 * @author vinicius
 * @version 1.0
 */
@Entity
public class Institution implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String department;
    
    @Column(nullable = false)
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institution")
    private List<Phone> phones;

    public Institution() {
    }
    
    public Institution(String name, String department, String email, Address address, List<Phone> phones) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.address = address;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    
}
