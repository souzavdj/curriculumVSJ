/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.utils;

/**
 * Classe de utilidade para fazer a formatação dos dados.
 * @author vinicius
 * @version 1.0
 */
public class FormatData {
    
    public static String filterZipCode (String zipCode) {
        if(zipCode.contains("-")) {
            zipCode = zipCode.replace("-", "");
        }
        return zipCode;
    }
    
    public static String filterPhone (String phone) {
        if (phone.contains("(")) {
            phone = phone.replace("(", "");
        }
        if (phone.contains(")")) {
            phone = phone.replace(")", "");
        }
        if (phone.contains("-")) {
            phone = phone.replace("-", "");
        }
        return phone;
    }
    
}
