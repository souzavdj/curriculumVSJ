/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.view;

import br.com.vsj.curriculumvsj.control.AddressController;
import br.com.vsj.curriculumvsj.control.InstitutionController;
import br.com.vsj.curriculumvsj.control.PhoneController;
import br.com.vsj.curriculumvsj.model.entity.Address;
import br.com.vsj.curriculumvsj.model.entity.Institution;
import br.com.vsj.curriculumvsj.model.entity.Phone;
import br.com.vsj.curriculumvsj.utils.ServletUtils;
import br.com.vsj.curriculumvsj.utils.ValidUtils;
import java.io.IOException;
import java.io.PrintWriter;
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
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        String phone = req.getParameter("phone");
        //Address
        String zipCode = req.getParameter("zipCode");
        String street = req.getParameter("street");
        String number = req.getParameter("number");
        String complement = req.getParameter("complement");
        String neighborhood = req.getParameter("neighborhood");
        String city = req.getParameter("city");
        String stage = req.getParameter("stage");
        String country = req.getParameter("country");
        boolean valid = true;
        Locale locale = ServletUtils.getLocale(req);
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
        req.setAttribute("stageIsValid", "is-valid");
        req.setAttribute("countryIsValid", "is-valid");
        
        //Validação Nome
        if (!ValidUtils.validFieldEmpty(name)) {
            valid = false;
            req.setAttribute("nameIsValid", "is-invalid");
            req.setAttribute("nameSpace", true);
            req.setAttribute("nameMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.name.inValid"));
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
        }
        
        //Validação Departamento
        if(!ValidUtils.validFieldEmpty(department)) {
            valid = false;
            req.setAttribute("departmentIsValid", "is-invalid");
            req.setAttribute("departmentSpace", true);
            req.setAttribute("departmentMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.department.inValid"));
        }
        
        //Validação Telefones
        if(!ValidUtils.validFieldEmpty(phone)) {
            valid = false;
            req.setAttribute("phoneIsValid", "is-invalid");
            req.setAttribute("phoneSpace", true);
            req.setAttribute("phoneMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.phone.inValid"));
        }
        
        //Validação CEP
        if(!ValidUtils.validFieldEmpty(zipCode)) {
            valid = false;
            req.setAttribute("zipCodeIsValid", "is-invalid");
            req.setAttribute("zipCodeMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.inValid"));
        }
        
        //Validação Rua
        if(!ValidUtils.validFieldEmpty(street)) {
            valid = false;
            req.setAttribute("streetIsValid", "is-invalid");
            req.setAttribute("streetMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.street.inValid"));
        }
        
        //Validação Número
        if(!ValidUtils.validFieldEmpty(number)) {
            valid = false;
            req.setAttribute("numberIsValid", "is-invalid");
            req.setAttribute("numberMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.number.inValid"));
        }
        
        //Validação Complemento
        if(!ValidUtils.validFieldEmpty(complement)) {
            valid = false;
            req.setAttribute("complementIsValid", "is-invalid");
            req.setAttribute("complementMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.complement.inValid"));
        }
        
        //Validação Bairro
        if(!ValidUtils.validFieldEmpty(neighborhood)) {
            valid = false;
            req.setAttribute("neighborhoodIsValid", "is-invalid");
            req.setAttribute("neighborhoodMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.neighborhood.inValid"));
        }
        
        //Validação Cidade
        if(!ValidUtils.validFieldEmpty(city)) {
            valid = false;
            req.setAttribute("cityIsValid", "is-invalid");
            req.setAttribute("cityMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.city.inValid"));
        }
        
        //Validação Estado
        if(!ValidUtils.validFieldEmpty(stage)) {
            valid = false;
            req.setAttribute("stageIsValid", "is-invalid");
            req.setAttribute("stageMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.stage.inValid"));
        }
        
        //Validação País
        if(!ValidUtils.validFieldEmpty(country)) {
            valid = false;
            req.setAttribute("countryIsValid", "is-invalid");
            req.setAttribute("countryMsgError", messages.getString("br.com.curriculumVSJ.Form_Institution.label.country.inValid"));
        }
        
        if (valid) {
            Address address = new Address(zipCode, Integer.parseInt(number), street, complement, neighborhood, city, stage, country);
            List<Phone> phones = new ArrayList();
            Phone phoneClass = new Phone(phone);
            phones.add(phoneClass);
            Institution institution = new Institution(name, department, email, address, phones);
            try{
                PhoneController.insertPhone(phoneClass);
                String msg = messages.getString("br.com.curriculumVSJ.Form_Institution.msg.success");
                req.setAttribute("msgSuccess", msg);
                req.getRequestDispatcher("/Form_Institution.jsp").forward(req, resp);			
            }catch(Exception e) {
                Logger lg = Logger.getLogger(FormInstitutionServlet.class);
                lg.error("Exceção ao tentar inserir a Instituição", e);
                req.setAttribute("error", e);
                req.setAttribute("msgError", e.getStackTrace());
                req.getRequestDispatcher("Error.jsp").forward(req, resp);			
            }
            req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("Form_Institution.jsp").forward(req, resp);
        }
        
    }

}
