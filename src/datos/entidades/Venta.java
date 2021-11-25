package datos.entidades;
import java.sql.Date;

public class Venta extends Entidad{
    
    private Date fechaVenta;
    private float totalVenta; 

    public Venta() {
        super();
        this.id=0;
        this.fechaVenta = null;
        this.totalVenta = 0.0f;
    }
    
    public Venta(Date fechaVenta, float totalVenta) {
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }
    
    public Venta(int id, Date fechaVenta, float totalVenta) {
        super(id);
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    
}
