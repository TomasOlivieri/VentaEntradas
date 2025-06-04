package VentaEntradas.Model;

public class Venta {
    private int comprobante;
    private Espectaculo espectaculoId;
    private Usuario usuarioId;
    private String documentoComprador;

    
    //CONSTRUCTORES
    public Venta (int comprobante, Espectaculo espec, Usuario usuario, String documentoComp) {
        this.comprobante = comprobante;
        this.espectaculoId = espec;
        this.usuarioId = usuario;
        this.documentoComprador = documentoComp;
    }


    //GETTERS Y SETTERS
    public Usuario getUsuarioId() {
        return usuarioId;
    }
    public int getComprobante() {
        return comprobante;
    }
    public Espectaculo getEspectaculoId() {
        return espectaculoId;
    }
    public String getDocumentoComprador() {
        return documentoComprador;
    }
}
