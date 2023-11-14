/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import static Conexion.Conexion.getConnection;

import Entidad.Au;
import Entidad.Cursos;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class F_AU {

    public int Guardar(Au e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_insert_aula(?,?,?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getSecion());
            cmd.setInt(3, e.getCantidad());
            cmd.setString(4, e.getNivel());
            cmd.setString(5, e.getGrado());

            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int Modificar(Au e) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_mod_aula(?,?,?,?,?)}");

            cmd.setString(1, e.getCodigo());
            cmd.setString(2, e.getSecion());
            cmd.setInt(3, e.getCantidad());
            cmd.setString(4, e.getNivel());
            cmd.setString(5, e.getGrado());

            respuesta = cmd.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        }
        return respuesta;
    }

    public int Eliminar(Au a) {
        int respuesta = 0;
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_eli_aula(?)}");
            cmd.setString(1, a.getCodigo());
            respuesta = cmd.executeUpdate();

        } catch (SQLException x1) {
            System.out.println(x1);
        }

        return respuesta;
    }

    public static ArrayList<Au> ListaAulas() {
        ArrayList<Au> Lista = new ArrayList<>();
        try {
            CallableStatement cmd = getConnection().prepareCall("{CALL sp_listar_aula}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Au l = new Au();
                l.setCodigo(rs.getString(1));
                l.setSecion(rs.getString(2));
                l.setCantidad(rs.getInt(3));
                l.setNivel(rs.getString(4));
                l.setGrado(rs.getString(5));

                Lista.add(l);
            }
        } catch (SQLException e) {
        }
        return Lista;
    }
}
