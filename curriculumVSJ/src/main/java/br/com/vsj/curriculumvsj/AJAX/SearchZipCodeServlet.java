/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.AJAX;

import br.com.vsj.curriculumvsj.model.entity.Address;
import br.com.vsj.curriculumvsj.utils.FormatData;
import br.com.vsj.curriculumvsj.utils.SearcherAddress;
import br.com.vsj.curriculumvsj.utils.ServletUtils;
import br.com.vsj.curriculumvsj.utils.ValidUtils;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
//import javax.json.bind.Jsonb;
//import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Classe Servlet para buscar o endereço atraves do cep.
 * @author vinicius
 * @version 1.0
 */
@WebServlet("/SearchZipCodeServlet")
public class SearchZipCodeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Locale locale = ServletUtils.getLocale(req,resp);
	ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        String zipCode = req.getParameter("zipCode");
        zipCode = FormatData.filterZipCode(zipCode);
        String zipCodeIsValid = "";
        String zipCodeMsgError = "";
        boolean valid = true;
        if (ValidUtils.validFieldEmpty(zipCode)) {
            if (ValidUtils.validZipCodeSize(zipCode)) {
                if (ValidUtils.validFieldIsNumberInteger(zipCode)) {
                    zipCodeIsValid = "is-valid";
                    req.setAttribute("zipCodeIsValid", zipCodeIsValid);
                }else {
                    //não é só numero
                    valid = false;
                    zipCodeIsValid = "is-invalid";
                    req.setAttribute("zipCodeIsValid", zipCodeIsValid);
                    zipCodeMsgError = messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.formatInValid");
                    req.setAttribute("zipCodeMsgError", zipCodeMsgError);
                }
            }else {
                //tamanho 
                valid = false;
                zipCodeIsValid = "is-invalid";
                req.setAttribute("zipCodeIsValid", zipCodeIsValid);
                zipCodeMsgError = messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.sizeInValid");
                req.setAttribute("zipCodeMsgError", zipCodeMsgError);
            }
        }else {
            //null
            valid = false;
            zipCodeIsValid = "is-invalid";
            req.setAttribute("zipCodeIsValid", zipCodeIsValid);
            zipCodeMsgError = messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.inValid");
            req.setAttribute("zipCodeMsgError", zipCodeMsgError);
        }
        
        if (valid) {
            Address address = new Address();
            try {
                address = SearcherAddress.getAddressByZipCode(zipCode);
            }catch (Exception e) {
                Logger lg = Logger.getLogger(SearchZipCodeServlet.class);
                lg.error("Exceção ao tentar buscar cep", e);
                req.setAttribute("error", e);
                req.setAttribute("msgError", e.getStackTrace());
                req.getRequestDispatcher("Error.jsp").forward(req, resp);
            }
            //Jsonb jsonb = JsonbBuilder.create();
            //String jsonResposta = jsonb.toJson(address);
            if (address != null) {
                String jsonResposta = "{\"street\": \""+address.getStreet()+"\", \"neighborhood\":\""+address.getNeighborhood()+"\", \"city\":\""+address.getCity()+"\", \"state\":\""+address.getState()+"\", \"country\":\""+address.getCountry()+"\"}";
                resp.getWriter().print(jsonResposta);
            }else {
                zipCodeIsValid = "is-invalid";
                zipCodeMsgError = messages.getString("br.com.curriculumVSJ.Form_Institution.label.zipCode.notFound");
                String jsonResposta = "{\"zipCodeIsValid\": \""+zipCodeIsValid+"\", \"zipCodeMsgError\":\""+zipCodeMsgError+"\"}";
                resp.getWriter().print(jsonResposta);
            }
        }else {
            String jsonResposta = "{\"zipCodeIsValid\": \""+zipCodeIsValid+"\", \"zipCodeMsgError\":\""+zipCodeMsgError+"\"}";
            resp.getWriter().print(jsonResposta);
        }
    }
}
