package datos.entidades;
import java.sql.Date;

public class Compra extends Entidad{
    
    private float totalCompra;
    private Date fechaCompra;
    
    public Compra() {
        super();
        this.id=0;
        this.totalCompra = 0.0f;
        this.fechaCompra = null;
    }
    public Compra(float totalCompra, Date fechaCompra) {
        this.totalCompra = totalCompra;
        this.fechaCompra = fechaCompra;
    }

    public Compra(int id, float totalCompra, Date fechaCompra) {
        super(id);
        this.totalCompra = totalCompra;
        this.fechaCompra = fechaCompra;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
