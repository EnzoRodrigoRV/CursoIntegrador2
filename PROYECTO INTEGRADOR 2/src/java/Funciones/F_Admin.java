package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Admin;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class F_Admin {

    public int GuardarAdmin(Admin e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_admin(?,?,?,?,?,?,?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setString(4, e.getEmail());
            cmd.setInt(5, e.getCelular());
            cmd.setInt(6, e.getDni());
            cmd.setString(7, e.getDireccion());
            cmd.setString(8, e.getUsu());
            cmd.setString(9, e.getPass());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int ModificarAdmin(Admin e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_admin(?,?,?,?,?,?,?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getApellido());
            cmd.setString(4, e.getEmail());
            cmd.setInt(5, e.getCelular());
            cmd.setInt(6, e.getDni());
            cmd.setString(7, e.getDireccion());
            cmd.setString(8, e.getUsu());
            cmd.setString(9, e.getPass());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public Admin Verificar(String cod) {
        Admin c = new Admin();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_verif_admin(?)}");
            cmd.setString(1, cod);
            ResultSet rs = cmd.executeQuery();
            if (!rs.next()) {
                c = null;
            }
        } catch (SQLException e) {
        }
        return c;
    }

    public int Eliminar(Admin a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eli_admin(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();

        } catch (SQLException x1) {
            System.out.println(x1);
        }

        return respuesta;
    }

    public static ArrayList<Admin> ListaAdmin() {
        ArrayList<Admin> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_admin}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Admin l = new Admin();
                l.setCodigo(rs.getString(1));
                l.setNombre(rs.getString(2));
                l.setApellido(rs.getString(3));
                l.setEmail(rs.getString(4));
                l.setCelular(rs.getInt(5));
                l.setDni(rs.getInt(6));
                l.setDireccion(rs.getString(7));
                l.setUsu(rs.getString(8));
                l.setPass(rs.getString(9));

                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
}
