package VentaEntradas.Model;

public class Espectaculo {
    private final int idEspectaculo;
    private String descripcion;
    private Estadio estadioId;
    private final Usuario usuarioId;

    //CONSTRUCTORES
    public Espectaculo (int idEspectaculo, String descripcion, 
                        Estadio estadio, Usuario usuario) {
        this.idEspectaculo = idEspectaculo;
        this.descripcion = descripcion;
        this.estadioId = estadio;
        this.usuarioId = usuario;
    }

    //GETTERS Y SETTERS
    public Estadio getEstadioId() {
        return estadioId;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getIdEspectaculo() {
        return idEspectaculo;
    }
    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEstadioId(Estadio estadioId) {
        this.estadioId = estadioId;
    }
}
