/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Database;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ub
 */
public class updateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Database db;
    Student std;

    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        db = new Database();
        std = new Student();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        db.close();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */

//            int id = Integer.parseInt(request.getParameter("id"));
//            String name = request.getParameter("name");
//            double gpa = Double.parseDouble(request.getParameter("gpa"));
            String idStr = request.getParameter("id");
            String nameStr = request.getParameter("name");
            String gpaStr = request.getParameter("gpa");

            ArrayList<String> listId = (ArrayList<String>) getServletContext().getAttribute("list");

            if (listId.contains(idStr)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet updateServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet updateServlet </h1>");
                out.println("<h2>update : " + idStr + "</h2>");
                out.println("<h2>result : can not do! this id working!</h2>");
                out.println("</body>");
                out.println("</html>");

            } else {
                listId.add(idStr);
                getServletContext().setAttribute("list", listId);
                synchronized (getServletContext()) {
                    getServletContext().setAttribute("id", Integer.parseInt(idStr));
                    getServletContext().setAttribute("name", nameStr);
                    getServletContext().setAttribute("gpa", Double.parseDouble(gpaStr));
                    std.setId((int) getServletContext().getAttribute("id"));
                    std.setName((String) getServletContext().getAttribute("name"));
                    std.setGpa((double) getServletContext().getAttribute("gpa"));
                    getServletContext().setAttribute("std", std);
                    String result = db.updateStudent((Student) getServletContext().getAttribute("std"));
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet updateServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet updateServlet </h1>");
                    out.println("<h2>result : " + result + "</h2>");
                    out.println("</body>");
                    out.println("</html>");
                }
                listId.remove(idStr);
                getServletContext().setAttribute("list", listId);
            }
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateServlet </h1>");
            out.println("<h2>Error : " + e + "</h2>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
