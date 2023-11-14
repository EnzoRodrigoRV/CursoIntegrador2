
package Funciones;

import static Conexion.Conexion.getConnection;
import Entidad.Cursos;
import Entidad.Matricula;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_Matricula {

    public int Guardar(Matricula e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_matricula(?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setDate(2, e.getFecha());
            cmd.setInt(3, e.getDni());

            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int Eliminar(Matricula a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eliminar_matricula(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();

        } catch (SQLException x1) {
            System.out.println(x1);
        }

        return respuesta;
    }

    public static ArrayList<Matricula> ListaMatricula() {
        ArrayList<Matricula> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_matricula}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {

                Matricula l = new Matricula();
                l.setCodigo(rs.getString(1));
                l.setFecha(rs.getDate(2));
                l.setDni(rs.getInt(3));

                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }

}
