/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import javax.swing.JOptionPane;

/**
 *
 * @author JorgePc
 */
public class SQLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        MetodosBase mt = new MetodosBase();
        mt.conectar();
        mt.crearNuevaTabla();
                
        int op;

        /*
        /Switch case para hacer el menu de la base de datos
        */
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("MENU \n1. Inserts \n2. Modificar dato \n3. Borrar \n4. Salir "));
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                op=0;
            }
            switch (op) {

                case 1:
                    mt.insertar(new Campos(JOptionPane.showInputDialog("Introducir ID: "), JOptionPane.showInputDialog("Introducir nombre: "), JOptionPane.showInputDialog("Introducir apellido: "), JOptionPane.showInputDialog("Introducir edad: ")));;
                    break;
                case 2:
                    mt.update(new Campos(JOptionPane.showInputDialog("Introducir ID: "), JOptionPane.showInputDialog("Introducir nombre: "), JOptionPane.showInputDialog("Introducir apellido: "), JOptionPane.showInputDialog("Introducir edad: ")));
                    break;
                case 3:
                   mt.borrar(JOptionPane.showInputDialog("Introducir ID del elemento a borrar: "));
                    break;
                case 4:
                    System.exit(0);
            }

        } while (op < 4);
    }
    
}
