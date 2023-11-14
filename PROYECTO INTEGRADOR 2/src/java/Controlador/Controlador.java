
package Controlador;

import Conexion.Conexion;
import Entidad.Admin;
import Entidad.Alumno;
import Entidad.Apoderado;
import Entidad.Au;
import Entidad.Aula;
import Entidad.Cursos;
import Entidad.Matricula;
import Entidad.Profesor;
import Funciones.F_Admin;
import Funciones.F_AU;
import Funciones.F_Alumno;
import Funciones.F_Apoderado;
import Funciones.F_Cursos;
import Funciones.F_Matricula;
import Funciones.F_Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private Connection con = new Conexion().getConnection();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equals("AgregarApoderado")) {
            this.GuardarApoderado(request, response);

        } else if (accion.equals("ModificarApoderado")) {
            this.ModificarApoderado(request, response);

        } else if (accion.equals("EliminarApoderado")) {
            this.EliminarApoderado(request, response);

        } else if (accion.equals("AgregarAlumno")) {
            this.GuardarAlumno(request, response);

        } else if (accion.equals("ModificarAlumno")) {
            this.ModificarAlumno(request, response);

        } else if (accion.equals("EliminarAlumno")) {
            this.EliminarAlumno(request, response);

        } else if (accion.equals("AgregarProfesor")) {
            this.GuardarProfesor(request, response);

        } else if (accion.equals("ModificarProfesor")) {
            this.ModificarProfesor(request, response);

        } else if (accion.equals("EliminarProfesor")) {
            this.EliminarProfesor(request, response);

        } else if (accion.equals("AgregarCurso")) {
            this.GuardarCursos(request, response);

        } else if (accion.equals("ModificarCurso")) {
            this.ModificarCursos(request, response);

        } else if (accion.equals("EliminarCurso")) {
            this.EliminarCursos(request, response);

        } else if (accion.equals("AgregarMatricula")) {
            this.GuardarMatricula(request, response);

        } else if (accion.equals("EliminarMatricula")) {
            this.EliminarMatricula(request, response);

        } else if (accion.equals("AgregarAula")) {
            this.GuardarAula(request, response);

        } else if (accion.equals("ModificarAula")) {
            this.ModificarAula(request, response);

        } else if (accion.equals("EliminarAula")) {
            this.EliminarAula(request, response);
        } else if (accion.equals("AgregarAdmin")) {
            this.GuardarAdmin(request, response);

        } else if (accion.equals("ModificarAdmin")) {
            this.ModificarAdmin(request, response);

        } else if (accion.equals("EliminarAdmin")) {
            this.EliminarAdmin(request, response);
        }

    }

    protected void GuardarApoderado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        int cel = Integer.parseInt(request.getParameter("txtCelular"));
        String dir = request.getParameter("txtDireccion");
        String cor = request.getParameter("txtEmail");

        Apoderado e = new Apoderado();

        e.setCodigo(cod);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setDni(dni);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setEmail(cor);

        F_Apoderado Obj = new F_Apoderado();
        int ret = Obj.GuardarApoderado(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaApoderado.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }

    }

    protected void ModificarApoderado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        int cel = Integer.parseInt(request.getParameter("txtCelular"));
        String dir = request.getParameter("txtDireccion");
        String cor = request.getParameter("txtEmail");

        Apoderado e = new Apoderado();

        e.setCodigo(cod);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setDni(dni);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setEmail(cor);

        F_Apoderado Obj = new F_Apoderado();
        int ret = Obj.ModificarApoderado(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaApoderado.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }
    }

    protected void EliminarApoderado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Apoderado e = new Apoderado();

        e.setCodigo(cod);

        F_Apoderado Obj = new F_Apoderado();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaApoderado.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }
    }

    protected void GuardarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        String sex = request.getParameter("txtSexo");
        String usu = request.getParameter("txtUsuario");
        String pass = request.getParameter("txtClave");
        String dir = request.getParameter("txtAula");
        String cor = request.getParameter("txtApoderado");

        Alumno e = new Alumno();

        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sex);
        e.setUsu(usu);
        e.setPass(pass);
        e.setCodaula(dir);
        e.setCodapod(cor);

        F_Alumno Obj = new F_Alumno();
        int ret = Obj.GuardarAlumno(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAlumno.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }

    }

    protected void ModificarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        String sex = request.getParameter("txtSexo");
        String usu = request.getParameter("txtUsuario");
        String pass = request.getParameter("txtClave");

        String dir = request.getParameter("txtAula");
        String cor = request.getParameter("txtApoderado");

        Alumno e = new Alumno();

        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sex);
        e.setUsu(usu);
        e.setPass(pass);
        e.setCodaula(dir);
        e.setCodapod(cor);

        F_Alumno Obj = new F_Alumno();
        int ret = Obj.ModificarAlumno(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAlumno.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
          
        }
    }

    protected void EliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int dni = Integer.parseInt(request.getParameter("txtDNI"));

        Alumno e = new Alumno();

        e.setDni(dni);

        F_Alumno Obj = new F_Alumno();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAlumno.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }
    }

    protected void GuardarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        String sex = request.getParameter("txtSexo");
        int cel = Integer.parseInt(request.getParameter("txtCelular"));
        String dir = request.getParameter("txtDireccion");
        String aula = request.getParameter("txtAula");

        Profesor e = new Profesor();

        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sex);
        e.setCodigo(cod);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setCodaula(aula);

        F_Profesor Obj = new F_Profesor();
        int ret = Obj.GuardarPofesor(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaDocente.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }

    }

    protected void ModificarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String ape = request.getParameter("txtApellido");
        String nom = request.getParameter("txtNombre");
        String sex = request.getParameter("txtSexo");
        int cel = Integer.parseInt(request.getParameter("txtCelular"));
        String dir = request.getParameter("txtDireccion");
        String aula = request.getParameter("txtAula");

        Profesor e = new Profesor();

        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sex);
        e.setCodigo(cod);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setCodaula(aula);

        F_Profesor Obj = new F_Profesor();
        int ret = Obj.ModificarProfesor(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaDocente.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "Error en el controlador");
        
        }
    }

    protected void EliminarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Profesor e = new Profesor();

        e.setCodigo(cod);

        F_Profesor Obj = new F_Profesor();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaDocente.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
        
        }
    }

    protected void GuardarCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String nom = request.getParameter("txtNombre");
        String prof = request.getParameter("txtProfesor");

        Cursos e = new Cursos();

        e.setNombre(nom);
        e.setCodigo(cod);
        e.setCodprof(prof);

        F_Cursos Obj = new F_Cursos();
        int ret = Obj.Guardar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaCurso.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }

    }

    protected void ModificarCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String nom = request.getParameter("txtNombre");
        String prof = request.getParameter("txtProfesor");

        Cursos e = new Cursos();

        e.setNombre(nom);
        e.setCodigo(cod);
        e.setCodprof(prof);

        F_Cursos Obj = new F_Cursos();
        int ret = Obj.Modificar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaCurso.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }
    }

    protected void EliminarCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Cursos e = new Cursos();

        e.setCodigo(cod);

        F_Cursos Obj = new F_Cursos();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaCurso.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }
    }

    protected void GuardarAula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String secc = request.getParameter("txtSeccion");
        int cant = Integer.parseInt(request.getParameter("txtCantidad"));
        String niv = request.getParameter("txtNivel");
        String gra = request.getParameter("txtGrado");

        Au e = new Au();

        e.setCodigo(cod);
        e.setSecion(secc);
        e.setCantidad(cant);
        e.setNivel(niv);
        e.setGrado(gra);

        F_AU Obj = new F_AU();
        int ret = Obj.Guardar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAula.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error de controlador");
           
        }

    }

    protected void ModificarAula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String secc = request.getParameter("txtSeccion");
        int cant = Integer.parseInt(request.getParameter("txtCantidad"));
        String niv = request.getParameter("txtNivel");
        String gra = request.getParameter("txtGrado");

        Au e = new Au();

        e.setCodigo(cod);
        e.setSecion(secc);
        e.setCantidad(cant);
        e.setNivel(niv);
        e.setGrado(gra);

        F_AU Obj = new F_AU();
        int ret = Obj.Modificar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAula.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }
    }

    protected void EliminarAula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Au e = new Au();

        e.setCodigo(cod);

        F_AU Obj = new F_AU();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAula.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }
    }

    protected void GuardarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        int dni = Integer.parseInt(request.getParameter("txtDNI"));

        Matricula e = new Matricula();

        e.setCodigo(cod);
        e.setFecha(fecha);
        e.setDni(dni);

        F_Matricula Obj = new F_Matricula();
        int ret = Obj.Guardar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaMatricula.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
//           
        }

    }

    protected void EliminarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Matricula e = new Matricula();

        e.setCodigo(cod);

        F_Matricula Obj = new F_Matricula();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaMatricula.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }
    }

    protected void GuardarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String nom = request.getParameter("txtNombre");
        String ape = request.getParameter("txtApellido");
        String email = request.getParameter("txtEmail");
        int cel = Integer.parseInt(request.getParameter("txtCel"));
        int dni = Integer.parseInt(request.getParameter("txtDni"));
        String dir = request.getParameter("txtDirec");
        String usu = request.getParameter("txtUsu");
        String pwd = request.getParameter("txtPass");
        Admin e = new Admin();

        e.setCodigo(cod);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setEmail(email);
        e.setCelular(cel);
        e.setDni(dni);
        e.setDireccion(dir);
        e.setUsu(usu);
        e.setPass(pwd);

        F_Admin Obj = new F_Admin();
        int ret = Obj.GuardarAdmin(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAdmin.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
            
        }

    }

    protected void ModificarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");
        String nom = request.getParameter("txtNombre");
        String ape = request.getParameter("txtApellido");
        String email = request.getParameter("txtEmail");
        int cel = Integer.parseInt(request.getParameter("txtCel"));
        int dni = Integer.parseInt(request.getParameter("txtDni"));
        String dir = request.getParameter("txtDirec");
        String usu = request.getParameter("txtUsu");
        String pwd = request.getParameter("txtPass");

        Admin e = new Admin();

        e.setCodigo(cod);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setEmail(email);
        e.setCelular(cel);
        e.setDni(dni);
        e.setDireccion(dir);
        e.setUsu(usu);
        e.setPass(pwd);

        F_Admin Obj = new F_Admin();
        int ret = Obj.ModificarAdmin(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAdmin.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
           
        }
    }

    protected void EliminarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("txtCodigo");

        Admin e = new Admin();

        e.setCodigo(cod);

        F_Admin Obj = new F_Admin();
        int ret = Obj.Eliminar(e);

        if (ret > 0) {
            request.getRequestDispatcher("Admin-ListaAdmin.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null, "error");
         
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
