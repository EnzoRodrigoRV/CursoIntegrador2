/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static Conexion.Conexion.getConnection;

public class Iniciar extends HttpServlet {

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
        try {
            String select = request.getParameter("select");
            String usu = request.getParameter("txtUsuario");
            String cla = request.getParameter("txtClave");

            if (select.equals("Alumno")) {

                CallableStatement cmd = getConnection().prepareCall("{CALL sp_iniciar_alumno(?,?)}");
                cmd.setString(1, usu);
                cmd.setString(2, cla);
                ResultSet rs = cmd.executeQuery();
                if (rs.next()) {
                    HttpSession SesionOK = request.getSession();
                    SesionOK.setAttribute("dni", rs.getString(1));
                    SesionOK.setAttribute("nombre", rs.getString(2));
                    SesionOK.setAttribute("usuario", rs.getString(2) + " " + rs.getString(3));
                    SesionOK.setAttribute("gmail", rs.getString(4));
                    SesionOK.setAttribute("mas", rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
                    RequestDispatcher dis = getServletContext().getRequestDispatcher("/Alumno-Intranet.jsp");
                    dis.forward(request, response);

                } else {
                    request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                }
            } else if (select.equals("Administrador")) {

                CallableStatement ad = getConnection().prepareCall("{CALL sp_iniciar_admin(?,?)}");
                ad.setString(1, usu);
                ad.setString(2, cla);
                ResultSet r = ad.executeQuery();
                if (r.next()) {
                    HttpSession SesionOK = request.getSession();
                    SesionOK.setAttribute("id", r.getString(1));
                    SesionOK.setAttribute("nombre", r.getString(2));
                    SesionOK.setAttribute("usuario", r.getString(2) + " " + r.getString(3));
                    SesionOK.setAttribute("gmail", r.getString(4));
                    SesionOK.setAttribute("mas", r.getString(5) + " " + r.getString(6) + " " + r.getString(7) + " " + r.getString(8) + " " + r.getString(9));
                    // request.getRequestDispatcher("Menu-Acceso.jsp").forward(request, response);

                    RequestDispatcher dis = getServletContext().getRequestDispatcher("/Admin-Menu.jsp");
                    dis.forward(request, response);

                } else {
                     request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                }
            } else if (select.equals("Docente")) {

                CallableStatement ad = getConnection().prepareCall("{CALL sp_inciar_profesor(?,?)}");
                ad.setString(1, usu);
                ad.setString(2, cla);
                ResultSet r = ad.executeQuery();
                if (r.next()) {
                    HttpSession SesionOK = request.getSession();
                    SesionOK.setAttribute("id", r.getString(1));
                    SesionOK.setAttribute("nombre", r.getString(2));
                    SesionOK.setAttribute("usuario", r.getString(2) + " " + r.getString(3));
                    SesionOK.setAttribute("gmail", r.getString(4));
                    SesionOK.setAttribute("mas", r.getString(5) + " " + r.getString(6));
                    SesionOK.setAttribute("mas", r.getString(5) + " " + r.getString(6) + " " + r.getString(7) + " " + r.getString(8));

                    RequestDispatcher dis = getServletContext().getRequestDispatcher("/Docente-Intranet.jsp");
                    dis.forward(request, response);

                } else {
                    request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                }
            }

        } catch (SQLException e) {

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
