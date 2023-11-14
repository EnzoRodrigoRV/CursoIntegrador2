    
package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Alumno;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_Alumno {

    public int GuardarAlumno(Alumno e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_alumno(?,?,?,?,?,?,?,?)}");

            cmd.setInt(1, e.getDni());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setString(4, e.getSexo());
            cmd.setString(5, e.getUsu());
            cmd.setString(6, e.getPass());
            cmd.setString(7, e.getCodaula());
            cmd.setString(8, e.getCodapod());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int ModificarAlumno(Alumno e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_alumno(?,?,?,?,?,?,?,?)}");

            cmd.setInt(1, e.getDni());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setString(4, e.getSexo());
            cmd.setString(5, e.getUsu());
            cmd.setString(6, e.getPass());
            cmd.setString(7, e.getCodaula());
            cmd.setString(8, e.getCodapod());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public Alumno Verificar(int dni) {
        Alumno c = new Alumno();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_verif_cliente(?)}");
            cmd.setInt(1, dni);
            ResultSet rs = cmd.executeQuery();
            if (!rs.next()) {
                c = null;
            }
        } catch (SQLException e) {
        }
        return c;
    }

    public int Eliminar(Alumno a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eli_alumno(?)}");
            cmd.setInt(1, a.getDni());
            respuesta = cmd.executeUpdate();

        } catch (SQLException x1) {
            System.out.println(x1);
        }

        return respuesta;
    }

    public static ArrayList<Alumno> ListaClientes() {
        ArrayList<Alumno> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_alumno}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Alumno l = new Alumno();
                l.setDni(rs.getInt(1));
                l.setNombre(rs.getString(2));
                l.setApellido(rs.getString(3));
                l.setSexo(rs.getString(4));
                l.setUsu(rs.getString(5));
                l.setPass(rs.getString(6));
                l.setCodaula(rs.getString(7));
                l.setCodapod(rs.getString(8));

                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
}
