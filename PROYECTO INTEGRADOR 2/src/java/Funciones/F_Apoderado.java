
package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Apoderado;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_Apoderado {
    
    public int GuardarApoderado(Apoderado e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_apoderado(?,?,?,?,?,?,?)}");
            
            cmd.setString(1, e.getCodigo());
            cmd.setInt(2, e.getDni());
            cmd.setString(3, e.getNombre());
            cmd.setString(4, e.getApellido());
            cmd.setString(5, e.getDireccion());
            cmd.setInt(6, e.getCelular());
            cmd.setString(7, e.getEmail());
            
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }
    
    public int ModificarApoderado(Apoderado e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_apoderado(?,?,?,?,?,?,?)}");
            
            cmd.setString(1, e.getCodigo());
            cmd.setInt(2, e.getDni());
            cmd.setString(3, e.getNombre());
            cmd.setString(4, e.getApellido());
            cmd.setString(5, e.getDireccion());
            cmd.setInt(6, e.getCelular());
            cmd.setString(7, e.getEmail());
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }
    
    public Apoderado Verificar(int dni) {
        Apoderado c = new Apoderado();
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
    
    public int Eliminar(Apoderado a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eli_apoderado(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();
            
        } catch (SQLException x1) {
            System.out.println(x1);
        }
        
        return respuesta;
    }
    
    public static ArrayList<Apoderado> ListaApoderador() {
        ArrayList<Apoderado> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_apoderado}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Apoderado l = new Apoderado();
                l.setCodigo(rs.getString(1));
                l.setDni(rs.getInt(2));
                l.setNombre(rs.getString(3));
                l.setApellido(rs.getString(4));
                l.setDireccion(rs.getString(5));
                l.setCelular(rs.getInt(6));
                l.setEmail(rs.getString(7));
                
                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
}
