package datos.entidades;

public class Puesto extends Entidad {
    
    private String descripcion;
    private float sueldo;

    public Puesto() {
        super();
        this.id = 0;
        this.descripcion = null;
        this.sueldo = 0.0f;
    }

    public Puesto(String descripcion, float sueldo) {
        this.descripcion = descripcion;
        this.sueldo = sueldo;
    }

    public Puesto(String descripcion, float sueldo, int id) {
        super(id);
        this.descripcion = descripcion;
        this.sueldo = sueldo;
    }
    
    
    
    
}
