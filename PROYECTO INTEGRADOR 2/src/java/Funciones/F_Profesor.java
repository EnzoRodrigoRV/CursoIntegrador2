
package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Profesor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_Profesor {

    public int GuardarPofesor(Profesor e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_profesor(?,?,?,?,?,?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setInt(4, e.getDni());
            cmd.setInt(5, e.getCelular());
            cmd.setString(6, e.getDireccion());
            cmd.setString(7, e.getSexo());
            cmd.setString(8, e.getCodaula());

            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int ModificarProfesor(Profesor e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_profesor(?,?,?,?,?,?,?,?)}");
            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setInt(4, e.getDni());
            cmd.setInt(5, e.getCelular());
            cmd.setString(6, e.getDireccion());
            cmd.setString(7, e.getSexo());
            cmd.setString(8, e.getCodaula());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public Profesor Verificar(int dni) {
        Profesor c = new Profesor();
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

    public int Eliminar(Profesor a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eliminar_profesor(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();

        } catch (SQLException x1) {
            System.out.println(x1);
        }

        return respuesta;
    }

    public static ArrayList<Profesor> ListaProfesores() {
        ArrayList<Profesor> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_profesor}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Profesor l = new Profesor();

                l.setCodigo(rs.getString(1));
                l.setNombre(rs.getString(2));
                l.setApellido(rs.getString(3));
                l.setDni(rs.getInt(4));
                l.setCelular(rs.getInt(5));
                l.setDireccion(rs.getString(6));
                l.setSexo(rs.getString(7));
                l.setCodaula(rs.getString(8));

                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
}
