/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.utils;

/**
 * Classe de utilidade para efetuar a validação de campos.
 * @author vinicius
 * @version 1.0
 */
public class ValidUtils {
    
    public static boolean validEmail (String email) {
        boolean valid = false;
        if (email.contains("@") && email.contains(".")) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validEmailCorrect (String email) {
        boolean valid = false;
        if (email.equals("vinizagueiro@gmail.com")) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validPassword (String password) {
        boolean valid = false;
        if (!password.isEmpty()) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validPasswordCorrect (String password) {
        boolean valid = false;
        if (password.equals("gude0718")) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validFieldEmpty (String field) {
        boolean valid = false;
        if (field != null && !field.isEmpty() && field.trim() != "") {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validFieldIsNumberInteger (String field) {
        boolean valid = false;
        try {
            int integer = Integer.parseInt(field);
            valid = true;
        }catch (NumberFormatException n) {
            valid = false;
        }
        return valid;
    }
    
    public static boolean validFieldIsNumberDouble (String field) {
        boolean valid = false;
        try {
            double integer = Double.parseDouble(field);
            valid = true;
        }catch (NumberFormatException n) {
            valid = false;
        }
        return valid;
    }
    
    public static boolean validZipCodeSize (String zipCode) {
        boolean valid = false;
        if (zipCode.length() == 8) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validMaxLengthString (String param) {
        if (param.length() < 255) {
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean validMaxLengthPhone (String phone) {
        if (phone.length() < 12) {
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean validMaxLengthNumberAddress (String number) {
        if (number.length() < 9) {
            return true;
        }else {
            return false;
        }
    }
}
