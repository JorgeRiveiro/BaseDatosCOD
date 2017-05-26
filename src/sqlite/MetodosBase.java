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
    public static Connection conexion = null;
    public static Statement s = null ;
    public static String db = "Alumnos.db";
    public static String nome;
    public static String apellidos;
    public static int id;
    public static int edad;
   
    
    public Connection conectar() {
        // Crea la nueva bas de datos
        String url = "jdbc:sqlite:" + db;
        
         try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("El nombre del driver es " + meta.getDriverName());
                System.out.println("Nueva Base de Datos creada.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        //Conecta a la base de datos
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
        
    }
    public void crearNuevaTabla() {
        String url = "jdbc:sqlite:" + db;
        
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
    
    public void insertar() {
        String sql = "INSERT INTO alumnos(nombre,apellidos,edad) VALUES(?,?,?)";
 
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, apellidos);
            pstmt.setInt(3, edad);
            pstmt.executeUpdate();
            System.out.println("Datos insertados");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ver(){
        String sql = "SELECT id, nombre, apellidos, edad FROM alumnos";
        
        try (Connection conn = this.conectar();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("nombre") + "\t" +
                                   rs.getString("apellidos")+ "\t" +
                                   rs.getInt("edad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void update() {
        String sql = "UPDATE alumnos SET nombre = ? , "
                + "apellidos = ? , "
                + "edad = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            pstmt.setString(1, nome);
            pstmt.setString(2, apellidos);
            pstmt.setInt(3, edad);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void delete() {
        String sql = "DELETE FROM alumnos WHERE id = ?";
 
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
