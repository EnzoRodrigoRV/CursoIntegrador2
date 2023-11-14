package Entidad;

import java.sql.Date;

public class Matricula {

    private String codigo;
    private Date fecha;
    private int dni;

    public Matricula() {
    }

    public Matricula(String codigo, Date fecha, int dni) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
