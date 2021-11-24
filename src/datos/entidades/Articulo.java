package datos.entidades;

public class Articulo extends Entidad{
    
    private String descripcion;
    private int idCategoria;
    private int idProveedor;
    private float precioCompra;
    private float precioVenta;
    private float existencia;
    
    public Articulo(){
        super();
        this.id = 0;
        this.descripcion = null;
        this.idCategoria = 0;
        this.idProveedor = 0;
        this.precioCompra = 0.0f;
        this.precioVenta = 0.0f;
        this.existencia = 0.0f;
    }

    public Articulo(String descripcion, int idCategoria, int idProveedor, float precioCompra, float precioVenta, float existencia) {
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
    }

    public Articulo(int id, String descripcion, int idCategoria, int idProveedor, float precioCompra, float precioVenta, float existencia ) {
        super(id);
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }
    
}
