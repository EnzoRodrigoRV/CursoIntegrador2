package Controlador;

import static Conexion.Conexion.getConnection;
import Entidad.Alumno;
import Entidad.Apoderado;
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

public class MostrarAlumno extends HttpServlet {

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

        int cod = Integer.parseInt(request.getParameter("cod"));
        Alumno c = new Alumno();
        Statement stmt;
        ResultSet rs;

        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("select Dni_Al, Nombre_Al, Apellido_Al, Sexo_Al, Usu_Al, Pass_Al, Codigo_Au, Codigo_Ap from Alumno where Dni_Al= " + cod + "");
            while (rs.next()) {

                c.setDni(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setUsu(rs.getString(5));
                c.setPass(rs.getString(6));
                c.setCodaula(rs.getString(7));
                c.setCodapod(rs.getString(8));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el proceso de consulta");
        }

        request.setAttribute("alumno", c);
        RequestDispatcher rd = request.getRequestDispatcher("Admin-ModAlumno.jsp");
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
