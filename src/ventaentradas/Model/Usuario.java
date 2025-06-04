package VentaEntradas.Model;

public class Usuario {
    private final int idUsuario;
    private String nombre;
    private String apellido;
    private String documento;
    private final int perfil;

    
    //CONSTRUCTORES
    public Usuario (int idUsuario, String nombre, String apellido, 
                    String documento, int perfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.perfil = perfil;
    }


    //GETERS Y SETERS
    public int getIdUsuario() {
        return idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDocumento() {
        return documento;
    }
    public int getPerfil() {
        return perfil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
}