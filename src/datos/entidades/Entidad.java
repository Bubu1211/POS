package datos.entidades;

public class Entidad {
    
    protected int id;
    
    public Entidad(){
        this.id = 0;
    }

    public Entidad(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
