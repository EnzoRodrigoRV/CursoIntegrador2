package Entidad;

public class Aula {

    private String codigo;
    private String seccion;
    private int cantidad;
    private String nivel;
    private String grado;

    public Aula() {
    }

    public Aula(String codigo, String seccion, int cantidad, String nivel, String grado) {
        this.codigo = codigo;
        this.seccion = seccion;
        this.cantidad = cantidad;
        this.nivel = nivel;
        this.grado = grado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

}
