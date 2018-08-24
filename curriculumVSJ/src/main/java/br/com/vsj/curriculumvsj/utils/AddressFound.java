/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.utils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Classe de utilidade que recupera o endereço no arquivo de Endereços.
 * @author vinicius
 * @version 1.0
 */
public class AddressFound {

    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String initials;
    private String zipCode;

    public void readAddress(DataInput din) throws IOException {
        byte street[] = new byte[72];
        byte neighborhood[] = new byte[72];
        byte city[] = new byte[72];
        byte state[] = new byte[72];
        byte initials[] = new byte[2];
        byte zipCode[] = new byte[8];

        din.readFully(street);
        din.readFully(neighborhood);
        din.readFully(city);
        din.readFully(state);
        din.readFully(initials);
        din.readFully(zipCode);
        din.readByte(); // Ultimo espaco em branco 
        din.readByte(); // Quebra de linha

        // Definie a forma como caracteres especias estão codificados.
        Charset enc = Charset.forName("ISO-8859-1");

        this.street = new String(street, enc);
        this.neighborhood = new String(neighborhood, enc);
        this.city = new String(city, enc);
        this.state = new String(state, enc);
        this.initials = new String(initials, enc);
        this.zipCode = new String(zipCode, enc);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
