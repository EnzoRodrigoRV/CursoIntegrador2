package Entidad;

public class Profesor {

    private String codigo;
    private String nombre;
    private String apellido;
    private int dni;
    private int celular;
    private String direccion;
    private String sexo;
    private String codaula;

    public Profesor() {
    }

    public Profesor(String codigo, String nombre, String apellido, int dni, int celular, String direccion, String sexo, String codaula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
        this.sexo = sexo;
        this.codaula = codaula;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodaula() {
        return codaula;
    }

    public void setCodaula(String codaula) {
        this.codaula = codaula;
    }

}
