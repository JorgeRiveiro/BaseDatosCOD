/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

/**
 *
 * @author Jorge
 */
public class Campos {
    String id, nombre, apellido, edad;

     /**
    * Constructor por defecto.
    */
    public Campos() {
    }

    /**
     * Constructor con variables.
     * @param id
     * @param nombre
     * @param apellido
     * @param edad 
     */
    public Campos(String id, String nombre, String apellido, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    /**
     * Getter id.
     * @return 
     */
    public String getId() {
        return id;
    }
    
    /**
     * Setter id.
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter nombre.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter nombre.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter apellido.
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter apellido.
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Getter edad.
     * @return 
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Setter edad.
     * @param edad 
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
}
