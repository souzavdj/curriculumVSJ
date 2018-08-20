/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.view;

import br.com.vsj.curriculumvsj.utils.ServletUtils;
import br.com.vsj.curriculumvsj.utils.ValidUtils;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Servlet para controle da JSP de Login.
 * @author vinicius
 * @version 1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>POST</code> method.
     * Método responsável por receber os dados do JSP Login e fazer a validação dos mesmo.
     * @param req um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean valid = true;
        Locale locale = ServletUtils.getLocale(req,resp);
	ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        req.setAttribute("emailIsValid", "is-valid");
        req.setAttribute("passwordIsValid", "is-valid");
        
        if (!ValidUtils.validEmail(email)) {
            valid = false;
            req.setAttribute("emailIsValid", "is-invalid");
            req.setAttribute("emailMsgError", messages.getString("br.com.curriculumVSJ.Login.valid.email.invalid"));
        }else if (!ValidUtils.validEmailCorrect(email)){
            valid = false;
            req.setAttribute("emailIsValid", "is-invalid");
            req.setAttribute("emailMsgError", messages.getString("br.com.curriculumVSJ.Login.valid.email.incorrect"));
        }
        if (!ValidUtils.validPassword(password)) {
            valid = false;
            req.setAttribute("passwordIsValid", "is-invalid");
            req.setAttribute("passwordMsgError", messages.getString("br.com.curriculumVSJ.Login.valid.password.invalid"));
        }else if (!ValidUtils.validPasswordCorrect(password)) {
            valid = false;
            req.setAttribute("passwordIsValid", "is-invalid");
            req.setAttribute("passwordMsgError", messages.getString("br.com.curriculumVSJ.Login.valid.password.incorrect"));
        }
        if (valid) {
            req.getSession().removeAttribute("login");
            req.getSession().setAttribute("login", true);
            req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * Método responsável por permitir trocar o locale na JSP após a validação de um campo.
     * @param req um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logout") != null) {
            boolean logout = Boolean.parseBoolean(req.getParameter("logout"));
            if (logout) {
                req.getSession().removeAttribute("login");
                req.getSession().setAttribute("login", false);
                req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        }else {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        
    }
    
    
}
