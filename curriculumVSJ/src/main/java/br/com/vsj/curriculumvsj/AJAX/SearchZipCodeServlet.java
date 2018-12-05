/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.AJAX;

import br.com.vsj.curriculumvsj.model.entity.Address;
import br.com.vsj.curriculumvsj.utils.SearcherAddress;
import java.io.IOException;
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
        String zipCode = req.getParameter("zipCode");
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
        String jsonResposta = "{\"street\": \""+address.getStreet()+"\", \"neighborhood\":\""+address.getNeighborhood()+"\", \"city\":\""+address.getCity()+"\", \"state\":\""+address.getState()+"\", \"country\":\""+address.getCountry()+"\"}";
        resp.getWriter().print(jsonResposta);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        String zipCode = req.getParameter("zipCode");
        System.out.println("O cep: "+zipCode);
        
        Address address = new Address();
        address.setZipCode(zipCode);
        address.setStreet("Rua");
        address.setNeighborhood("Bairro");
        address.setCity("Rio de Janeiro");
        address.setState("Rio de Janeiro");
        address.setCountry("Brasil");
        
        //Jsonb jsonb = JsonbBuilder.create();
        //String jsonResposta = jsonb.toJson(address);
        String jsonResposta = "{\"street\": \"Rua\", \"neighborhood\":\"Bairro\"}";
        resp.getWriter().print(jsonResposta);
    }
    
}
