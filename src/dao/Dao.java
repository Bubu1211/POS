package dao;

import java.sql.Connection;
import datos.entidades.Entidad;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilidades.excepciones.DAOException;

public abstract class Dao {
    
    protected Connection conexion;
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    
    public abstract ArrayList<Entidad> listar() throws DAOException;
    public abstract int insertar(Entidad entidad) throws DAOException;
    public abstract int modificar(Entidad entidad) throws DAOException;
    public abstract int eliminar(int id) throws DAOException;
    public abstract ArrayList<Entidad> listarResultSet() throws DAOException;
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
//    public ArrayList<Object[]> ejecutarJOIN(String join){
//        
//    }
}
