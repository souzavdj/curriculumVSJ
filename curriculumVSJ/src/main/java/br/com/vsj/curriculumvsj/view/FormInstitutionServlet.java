/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.view;

import br.com.vsj.curriculumvsj.control.InstitutionController;
import br.com.vsj.curriculumvsj.model.entity.Address;
import br.com.vsj.curriculumvsj.model.entity.Institution;
import br.com.vsj.curriculumvsj.model.entity.Phone;
import br.com.vsj.curriculumvsj.utils.FormatData;
import br.com.vsj.curriculumvsj.utils.ServletUtils;
import br.com.vsj.curriculumvsj.utils.ValidUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Classe Servlet para o controle de cadastro de Instituições
 * @author vinicius
 * @version 1.0
 */
@WebServlet("/FormInstitutionServlet")
public class FormInstitutionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name").toUpperCase().trim();
        String email = req.getParameter("email").toUpperCase().trim();
        String department = req.getParameter("department").toUpperCase().trim();
        String phone = req.getParameter("phone").toUpperCase().trim();
        //Address
        String zipCode = req.getParameter("zipCode").toUpperCase().trim();
        String street = req.getParameter("street").toUpperCase().trim();
        String number = req.getParameter("number").toUpperCase().trim();
        int numberInt = 0;
        String complement = req.getParameter("complement").toUpperCase().trim();
        String neighborhood = req.getParameter("neighborhood").toUpperCase().trim();
        String city = req.getParameter("city").toUpperCase().trim();
        String state = req.getParameter("state").toUpperCase().trim();
        String country = req.getParameter("country").toUpperCase().trim();
        boolean valid = true;
        Locale locale = ServletUtils.getLocale(req,resp);
	ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        req.setAttribute("nameIsValid", "is-valid");
        req.setAttribute("emailIsValid", "is-valid");
        req.setAttribute("departmentIsValid", "is-valid");
        req.setAttribute("phoneIsValid", "is-valid");
        req.setAttribute("zipCodeIsValid", "is-valid");
        req.setAttribute("streetIsValid", "is-valid");
        req.setAttribute("numberIsValid", "is-valid");
        req.setAttribute("complementIsValid", "is-valid");
        req.setAttribute("neighborhoodIsValid", "is-valid");
        req.setAttribute("cityIsValid", "is-valid");
        req.setAttribute("stateIsValid", "is-valid");
        req.setAttribute("countryIsValid", "is-valid");
        
        //Validação Nome
        if (!ValidUtils.validFieldEmpty(name)) {
            valid = false;
            req.setAttribute("nameIsValid", "is-invalid");
            req.setAttribute("nameSpace", true);
            req.setAttribute("nameMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.name.inValid"));
        }else if (!ValidUtils.validMaxLengthString(name)) {
            valid = false;
            req.setAttribute("nameIsValid", "is-invalid");
            req.setAttribute("nameSpace", true);
            req.setAttribute("nameMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.name.inValidMaxLength"));
        }
        
        //Validação Email
        if(!ValidUtils.validFieldEmpty(email)) {
            valid = false;
            req.setAttribute("emailIsValid", "is-invalid");
            req.setAttribute("emailSpace", true);
            req.setAttribute("emailMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.email.inValid"));
        }else if (!ValidUtils.validEmail(email)) {
            valid = false;
            req.setAttribute("emailIsValid", "is-invalid");
            req.setAttribute("emailSpace", true);
            req.setAttribute("emailMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.email.formateInValid"));
        }else if (!ValidUtils.validMaxLengthString(email)) {
            valid = false;
            req.setAttribute("emailIsValid", "is-invalid");
            req.setAttribute("emailSpace", true);
            req.setAttribute("emailMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.email.inValidMaxLength"));
        }
        
        //Validação Departamento
        if(!ValidUtils.validFieldEmpty(department)) {
            valid = false;
            req.setAttribute("departmentIsValid", "is-invalid");
            req.setAttribute("departmentSpace", true);
            req.setAttribute("departmentMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.department.inValid"));
        }else if(!ValidUtils.validMaxLengthString(department)) {
            valid = false;
            req.setAttribute("departmentIsValid", "is-invalid");
            req.setAttribute("departmentSpace", true);
            req.setAttribute("departmentMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.department.inValidMaxLength"));
        }
        
        //Validação Telefones
        if(!ValidUtils.validFieldEmpty(phone)) {
            valid = false;
            req.setAttribute("phoneIsValid", "is-invalid");
            req.setAttribute("phoneSpace", true);
            req.setAttribute("phoneMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.phone.inValid"));
        }else if (!ValidUtils.validFieldIsNumberDouble(FormatData.filterPhone(phone))) { 
            valid = false;
            req.setAttribute("phoneIsValid", "is-invalid");
            req.setAttribute("phoneSpace", true);
            req.setAttribute("phoneMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.phone.formatInValid"));
        }else if(!ValidUtils.validMaxLengthPhone(FormatData.filterPhone(phone))) {
            valid = false;
            req.setAttribute("phoneIsValid", "is-invalid");
            req.setAttribute("phoneSpace", true);
            req.setAttribute("phoneMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.phone.inValidMaxLength"));
        }else {
            phone = FormatData.filterPhone(phone);
        }
        
        //Validação CEP
        if(!ValidUtils.validFieldEmpty(zipCode)) {
            valid = false;
            req.setAttribute("zipCodeIsValid", "is-invalid");
            req.setAttribute("zipCodeMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.inValid"));
        }else if (!ValidUtils.validZipCodeSize(FormatData.filterZipCode(zipCode))) {
            valid = false;
            req.setAttribute("zipCodeIsValid", "is-invalid");
            req.setAttribute("zipCodeMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.sizeInValid"));
        }else if (!ValidUtils.validFieldIsNumberInteger(FormatData.filterZipCode(zipCode))) {
            valid = false;
            req.setAttribute("zipCodeIsValid", "is-invalid");
            req.setAttribute("zipCodeMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.formatInValid"));
        }else {
            zipCode = FormatData.filterZipCode(zipCode);
        }
        
        //Validação Rua
        if(!ValidUtils.validFieldEmpty(street)) {
            valid = false;
            req.setAttribute("streetIsValid", "is-invalid");
            req.setAttribute("streetMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.street.inValid"));
        }else if(!ValidUtils.validMaxLengthString(street)) {
            valid = false;
            req.setAttribute("streetIsValid", "is-invalid");
            req.setAttribute("streetMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.street.inValidMaxLength"));
        }
        
        //Validação Número
        if(!ValidUtils.validFieldEmpty(number)) {
            valid = false;
            req.setAttribute("numberIsValid", "is-invalid");
            req.setAttribute("numberMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.number.inValid"));
        }else if(!ValidUtils.validFieldIsNumberInteger(number)) {
            valid = false;
            req.setAttribute("numberIsValid", "is-invalid");
            req.setAttribute("numberMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.number.formatInValid"));
        }else if(!ValidUtils.validMaxLengthNumberAddress(number)) {
            valid = false;
            req.setAttribute("numberIsValid", "is-invalid");
            req.setAttribute("numberMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.number.inValidMaxLength"));
        }else {
            numberInt = Integer.parseInt(number);
        }
        
        //Validação Complemento
        //if(!ValidUtils.validFieldEmpty(complement)) {
        //    valid = false;
        //    req.setAttribute("complementIsValid", "is-invalid");
        //    req.setAttribute("complementMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.complement.inValid"));
        //}else 
        if(!ValidUtils.validMaxLengthString(complement)) {
            valid = false;
            req.setAttribute("complementIsValid", "is-invalid");
            req.setAttribute("complementMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.complement.inValidMaxLength"));
        }
        
        //Validação Bairro
        if(!ValidUtils.validFieldEmpty(neighborhood)) {
            valid = false;
            req.setAttribute("neighborhoodIsValid", "is-invalid");
            req.setAttribute("neighborhoodMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.neighborhood.inValid"));
        }else if (!ValidUtils.validMaxLengthString(neighborhood)) {
            valid = false;
            req.setAttribute("neighborhoodIsValid", "is-invalid");
            req.setAttribute("neighborhoodMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.neighborhood.inValidMaxLength"));
        }
        
        //Validação Cidade
        if(!ValidUtils.validFieldEmpty(city)) {
            valid = false;
            req.setAttribute("cityIsValid", "is-invalid");
            req.setAttribute("cityMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.city.inValid"));
        }else if(!ValidUtils.validMaxLengthString(city)) {
            valid = false;
            req.setAttribute("cityIsValid", "is-invalid");
            req.setAttribute("cityMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.city.inValidMaxLength"));
        }
        
        //Validação Estado
        if(!ValidUtils.validFieldEmpty(state)) {
            valid = false;
            req.setAttribute("stateIsValid", "is-invalid");
            req.setAttribute("stateMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.state.inValid"));
        }else if(!ValidUtils.validMaxLengthString(state)) {
            valid = false;
            req.setAttribute("stateIsValid", "is-invalid");
            req.setAttribute("stateMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.state.inValidMaxLength"));
        }
        
        //Validação País
        if(!ValidUtils.validFieldEmpty(country)) {
            valid = false;
            req.setAttribute("countryIsValid", "is-invalid");
            req.setAttribute("countryMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.country.inValid"));
        }else if(!ValidUtils.validMaxLengthString(country)) {
            valid = false;
            req.setAttribute("countryIsValid", "is-invalid");
            req.setAttribute("countryMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.country.inValidMaxLength"));
        }
        
        if (valid) {
            Address address = new Address(zipCode, numberInt, street, complement, neighborhood, city, state, country);
            List<Phone> phones = new ArrayList();
            Phone phoneClass = new Phone(phone);
            phones.add(phoneClass);
            Institution institution = new Institution(name, department, email, address, phones);
            phoneClass.setInstitution(institution);
            try{
                InstitutionController.insertInstitution(institution);
                String msg = messages.getString("br.com.curriculumVSJ.Form_Institution.msg.success");
                req.setAttribute("msgSuccess", msg);
                req.getRequestDispatcher("Form_Institution.jsp").forward(req, resp);
            }catch(Exception e) {
                Logger lg = Logger.getLogger(FormInstitutionServlet.class);
                lg.error("Exceção ao tentar inserir a Instituição", e);
                req.setAttribute("error", e);
                req.setAttribute("msgError", e.getStackTrace());
                req.getRequestDispatcher("Error.jsp").forward(req, resp);			
            }
        }else {
            req.getRequestDispatcher("Form_Institution.jsp").forward(req, resp);
        }
        
    }

}
