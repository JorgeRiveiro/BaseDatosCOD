/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JorgePc
 */
public class MetodosBase {

    static Connection con = null;
    static Statement s = null;
    public static String db;
    public static String url = "jdbc:sqlite:" +db;

    /**
    * Constructor por defecto
    */
    public MetodosBase() {
    }
   
    /**
    * Constructor que recibe un string para dar nombre a la base de datos
    * @param db
    */
     public MetodosBase(String db){
        this.db = "alumnos.db";
    }
     
     /**
      * Metodo para conectar a la base de datos, devuelve false si no se conecta y true si lo hace
      * @return 
      */
    public boolean conectar() {

        String url = "jdbc:sqlite:" + db;

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
        
    }
    
    /**
     * Metodo para crear una nueva tabla en la base de datos
     */
    public void crearNuevaTabla() {
        
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellidos text NOT NULL,\n"
                + "     edad integer NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inserta en la tabla los campos id, nombre, apellido y edad
     * Devuelve un 0 si no se inserta nada y un 1 si se inserta
     * @param c
     * @return 
     */
    public int insertar(Campos c) {
        String sql = "INSERT INTO alumnos(id,nombre,apellidos,edad) VALUES(?,?,?,?)";
 
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, c.getId());
            pstmt.setString(2, c.getNombre());
            pstmt.setString(3, c.getApellido());
            pstmt.setString(4, c.getEdad());
            pstmt.executeUpdate();
            System.out.println("Datos insertados");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
    
    /**
     * Metodo para modificar los alumnos en la base de datos segun el id
     * Devuelve un 0 si no se inserta nada y un 1 si se inserta
     * @param c
     * @return 
     */
    public int update(Campos c) {
        String sql = " 'UPDATE alumnos SET nombre = '"+c.getNombre()
                + " 'apellidos = '" + c.getApellido()
                + " 'edad =' " + c.edad
                + "WHERE id =" + c.getId();
 
        try {
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
    
    /**
     * Metodo para borrar campos segun el id
     * Devuelve un 0 si no se inserta nada y un 1 si se inserta
     * @param id
     * @return 
     */
     public int borrar(String id) {
        String sql = "DELETE FROM alumnos WHERE id =" + id;
 
        try {
             Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
}
