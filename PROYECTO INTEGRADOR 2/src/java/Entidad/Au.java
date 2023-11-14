package Entidad;

public class Au {

    private String codigo;
    private String secion;
    private int cantidad;
    private String nivel;

    private String grado;

    public Au() {
    }

    public Au(String codigo, String secion, int cantidad, String nivel, String grado) {
        this.codigo = codigo;
        this.secion = secion;
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

    public String getSecion() {
        return secion;
    }

    public void setSecion(String secion) {
        this.secion = secion;
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
