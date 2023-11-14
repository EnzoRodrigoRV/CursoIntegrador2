package Entidad;

public class Cursos {

    private String codigo;
    private String nombre;
    private String codprof;

    public Cursos() {
    }

    public Cursos(String codigo, String nombre, String codprof) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codprof = codprof;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodprof() {
        return codprof;
    }

    public void setCodprof(String codprof) {
        this.codprof = codprof;
    }

}
