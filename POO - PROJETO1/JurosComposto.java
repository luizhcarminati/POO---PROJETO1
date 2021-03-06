/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.projeto01;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
public class JurosComposto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosComposto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Projeto 01</h1>");
            out.println("<h2>Juros-Composto</h2>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("<input type = 'text' name= 'capital' />");
            out.println("<input type = 'text' name= 'taxa' />");
            out.println("<input type = 'text' name= 'mes' />");
            out.println("<input type = 'submit' name= 'montante' value ='Calcular montante'/>");
            out.println("</form>");
            out.println("<hr/>");
            if (request.getParameter("montante")!=null){
                try{
                    double capital = Double.parseDouble(request.getParameter("capital"));
                    double taxa = Double.parseDouble(request.getParameter("taxa"));
                    int mes  = Integer.parseInt(request.getParameter("mes"));
                    out.println("<table>");
                    for (int i=1; i<mes+1; i++){
                         out.println("<tr>");
                         out.println("<td>"+ i +"º mês </td>");
                         /*double n = Math.ceil(capital * Math.pow(1 +(taxa/100),i));*/
                         double n = capital * Math.pow(1 +(taxa/100),i);
                         BigDecimal bd = new BigDecimal(n).setScale(2, RoundingMode.HALF_EVEN);
                         out.println("<td>R$ "+ bd +"</td>");
                         out.println("</tr>");
                }
                    out.println("</table>");
                    /*  double montante = Math.ceil(capital * Math.pow(1 +(taxa/100),mes));*/
                    double montante = capital * Math.pow(1 +(taxa/100),mes);
                    BigDecimal bd = new BigDecimal(montante).setScale(2, RoundingMode.HALF_EVEN);
                    out.println("<h1>A aplicação de R$ "+ capital +" a taxa de "+ taxa +" % ao mês, durante "+ mes +" mês(s), dará um montante no valor de R$ "+ bd +"</h1>");
                }catch (NumberFormatException ex){
                    out.println("<h2 style='color:red;'>Erro ao calcular os campos</h2>");
                }
            }
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
