package VentaEntradas.Model;

public class Estadio {
    private final int idEstadio;
    private String descripcion;
    private int capacidad;


    //CONSTRUCTORES
    public Estadio (int idEstadio, String descripcion, int capacidad) {
        this.idEstadio = idEstadio;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    //GETERS Y SETERS
    public int getIdEstadio() {
        return idEstadio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getCapacidad() {
        return capacidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
