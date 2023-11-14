/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Conexion.Conexion.getConnection;
import Entidad.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class MostrarEliDocente extends HttpServlet {

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
        String cod = request.getParameter("cod");
        Profesor c = new Profesor();
        Statement stmt;
        ResultSet rs;

        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("select Codigo_Pr, Nombre_Pr , Apellido_Pr, Dni_Pr, Celular_Pr, Direccion_Pr, Sexo_Pr , Codigo_Au from Profesor where Codigo_Pr= '" + cod + "'");
            while (rs.next()) {

                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getInt(4));
                c.setCelular(rs.getInt(5));
                c.setDireccion(rs.getString(6));
                c.setSexo(rs.getString(7));
                c.setCodaula(rs.getString(8));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el proceso de consulta");
        }

        request.setAttribute("docente", c);
        RequestDispatcher rd = request.getRequestDispatcher("Admin-EliDocente.jsp");
        rd.forward(request, response);
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
