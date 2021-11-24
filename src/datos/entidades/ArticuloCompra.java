package datos.entidades;

public class ArticuloCompra extends Entidad{
    
    private int idArticulo;
    private int idCompra;
    private float cantidadArticulo;

    public ArticuloCompra() {
        super();
        this.idArticulo =0;
        this.idCompra = 0;
        this.cantidadArticulo = 0.0f;
    }
    
    public ArticuloCompra(int idArticulo, int idCompra, float cantidadArticulo) {
        this.idArticulo = idArticulo;
        this.idCompra = idCompra;
        this.cantidadArticulo = cantidadArticulo;
    }

    public ArticuloCompra(int idArticulo, int idCompra, float cantidadArticulo, int id) {
        super(id);
        this.idArticulo = idArticulo;
        this.idCompra = idCompra;
        this.cantidadArticulo = cantidadArticulo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public float getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(float cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }
}
