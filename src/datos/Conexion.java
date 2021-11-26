package datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import utilidades.excepciones.BDException;

public class Conexion {

    private Connection conexion;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/tiendacedalex?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String USER = "root";
<<<<<<< HEAD
    private final String PASS = "admin";
=======
<<<<<<< HEAD
    private final String PASS = "123456";
=======

    private final String PASS = "Iuy7643mm+";
>>>>>>> 1c86fa97b6a402ac378f950d5ba0a7fccdb301d6




>>>>>>> a28b32b6b97e3df093b9f885ba37465c6348269c


    ///Solo crea la conexion 
    public void iniciarConexion() throws BDException {

        try {
            if (this.conexion == null) {
                Class.forName(DRIVER);
                this.conexion = (Connection) DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException ex) {
            throw new BDException(ex.getMessage(), "Iniciando la conexión con la BD");
        } catch (ClassNotFoundException ex) {
            throw new BDException(ex.getMessage(), "Asginación de clase del DRIVER");
        }
    }

    ///para podier usarla se usa getConexion
    public Connection getConexion() throws BDException {
        if (this.conexion == null) {
            throw new BDException("Está tratando de acceder a una conexión cerrada");
        }

        return this.conexion;
    }

    public void cerrarConexion() throws BDException {
        try {
            if (this.conexion == null) {
                throw new BDException("Esta tratando de cerrar una conexión cerrada o vacía", "Cerrando conexión");
            } else {
                this.conexion.close();
                this.conexion = null;
            }
        } catch (SQLException ex) {
            throw new BDException(ex.getMessage(), "Cerrando la Conexion con la Base de datos");
        }
    }
}
