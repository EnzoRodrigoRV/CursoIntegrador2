package Controlador;

import static Conexion.Conexion.getConnection;
import Entidad.Admin;
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

public class MostrarEliAdmin extends HttpServlet {

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
        Admin c = new Admin();
        Statement stmt;
        ResultSet rs;

        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("select Codigo_Ad,Nombre_Ad,Apellido_Ad,Email_Ad,Celular_Ad,Dni_Ad,Direccion_Ad,Usu_Ad,Pass_Ad from Administrador where Codigo_Ad= '" + cod + "'");
            while (rs.next()) {
                c.setCodigo(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setCelular(rs.getInt(5));
                c.setDni(rs.getInt(6));
                c.setDireccion(rs.getString(7));
                c.setUsu(rs.getString(8));
                c.setPass(rs.getString(9));


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el proceso de consulta");
        }

        request.setAttribute("admin", c);
        RequestDispatcher rd = request.getRequestDispatcher("Admin-EliAdmin.jsp");
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
