package Jc.dominio;

public class Estudiante {
    private int idEstudiantes;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Estudiante() {
    }

    public Estudiante(int idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }
    public Estudiante(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Estudiante(int idEstudiantes, String nombre, String apellido, String telefono, String correo) {
        this.idEstudiantes = idEstudiantes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(int idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante " +
                "idEstudiante=" + idEstudiantes +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'';
    }
}
