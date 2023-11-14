
package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Cursos;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_Cursos {
    
    
      public int Guardar(Cursos e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_cursos(?,?,?)}");
            
            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getCodprof());
           
            
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }
    
    public int Modificar(Cursos e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_cursos(?,?,?)}");
            
           cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getNombre());
            cmd.setString(3, e.getCodprof());
            
            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }
    
    
    public int Eliminar(Cursos a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eli_cursos(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();
            
        } catch (SQLException x1) {
            System.out.println(x1);
        }
        
        return respuesta;
    }
    
    public static ArrayList<Cursos> ListaCursos() {
        ArrayList<Cursos> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_cursos}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Cursos l = new Cursos();
                l.setCodigo(rs.getString(1));
                l.setNombre(rs.getString(2));
                l.setCodprof(rs.getString(3));
               
                
                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
    
}
