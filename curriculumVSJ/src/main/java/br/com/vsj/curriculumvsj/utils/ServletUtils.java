package br.com.vsj.curriculumvsj.utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Classe de utilidade criada para criação de metodos estaticos uteis para outras Servlets.
 * @author vinicius
 * @since 1.0
 *
 */
public class ServletUtils {

    /**
     * Método estático para buscar o locale em qualquer escopo de atributos.
     * @param request requisição do usuário
     * @return Locale localização do usuário ou selecionado pela página
     * @throws ServletException caso a Locale não seja encontrada
     */
    public static Locale getLocale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Locale locale = null;

        Object localeFound = request.getParameter("lang");
        if (localeFound == null) {
            localeFound = request.getSession().getAttribute("lang");
        }

        if (localeFound == null) {
            localeFound = request.getLocale();
        }

        if (localeFound instanceof Locale) {
            locale = (Locale) localeFound;
        } else if (localeFound instanceof String) {
            String[] parts = ((String) localeFound).split("_");
            locale = new Locale(parts[0], parts[1].toUpperCase());
        } else {
            Logger lg = Logger.getLogger(ServletUtils.class);
            lg.error("Exceção ao tentar o Locale", new ServletException("Locale not found!!!"));
            request.setAttribute("error", new ServletException("Locale not found!!!").toString());
            request.setAttribute("msgError", new ServletException("Locale not found!!!").getStackTrace());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            //throw new ServletException("Locale not found!!!");
        }
        return locale;
    }

    /**
     * Método estático para formatar mensagens que precisam de formatação
     *
     * @param msg chave que deverá ser formatada
     * @param locale localização do usuário ou selecionado pela página
     * @param param O valor variável da mensagem
     * @return Mensagem formatada
     */
    public static String mensagemFormatada(String msg, Locale locale, Integer param) {
        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(locale);
        formatter.applyPattern(msg);

        msg = formatter.format(new Object[]{param});
        return msg;
    }

}
