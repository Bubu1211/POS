package utilidades.excepciones;

public class BDException extends Exception{
    
    private String origen;
    
    public BDException(String mensaje){
        super(mensaje);
    }
    
    public BDException(String mensaje, String origen){
        super(mensaje);
        this.origen = origen;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getOrigen(){
        return this.origen;
    }
}
