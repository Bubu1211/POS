package datos.entidades;

public class ArticuloVenta extends Entidad{
    
    private int idArticulo;
    private int idVenta;
    private float cantidadArticulo;

    public ArticuloVenta(){
        super();
        this.idArticulo = 0;
        this.idVenta = 0;
        this.cantidadArticulo = 0.0f;
    }
    
    public ArticuloVenta(int idArticulo, int idVenta, float cantidadArticulo) {
        this.idArticulo = idArticulo;
        this.idVenta = idVenta;
        this.cantidadArticulo = cantidadArticulo;
    }
    
    public ArticuloVenta(int id, int idArticulo, int idVenta, float cantidadArticulo) {
        super(id);
        this.idArticulo = idArticulo;
        this.idVenta = idVenta;
        this.cantidadArticulo = cantidadArticulo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(float cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }
}
