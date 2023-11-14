package Entidad;

public class Alumno {

    private int dni;
    private String nombre;
    private String apellido;
    private String sexo;
    private String usu;
    private String pass;
    private String codaula;
    private String codapod;

    public Alumno() {
    }

    public Alumno(int dni, String nombre, String apellido, String sexo, String usu, String pass, String codaula, String codapod) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.usu = usu;
        this.pass = pass;
        this.codaula = codaula;
        this.codapod = codapod;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCodaula() {
        return codaula;
    }

    public void setCodaula(String codaula) {
        this.codaula = codaula;
    }

    public String getCodapod() {
        return codapod;
    }

    public void setCodapod(String codapod) {
        this.codapod = codapod;
    }

}
