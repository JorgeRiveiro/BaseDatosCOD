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
        
        Ventana vent = new Ventana();
        vent.setVisible(true);
//        MetodosBase mt = new MetodosBase();
//        int op;
//
//        do {
//            try {
//                op = Integer.parseInt(JOptionPane.showInputDialog(">>>MENU<<< \n1. Crear y conectar base \n2. Crear nueva tabla \n3. Insertar \n4. Ver \n5. Actualizar \n6 Borrar \n7 Salir "));
//                
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                op=0;
//            }
//            switch (op) {
//
//                case 1:
//                    mt.conectar();
//                    break;
//                case 2:
//                    mt.crearNuevaTabla();
//                    break;
//                case 3:
//                   mt.insertar("Jorge", "Riveiro", 21);
//                   mt.insertar("Jose", "Fuente", 18);
//                    break;
//                case 4:
//                    mt.ver();
//                    break;
//                case 5:
//                    mt.update(1, "Juan", "Rodriguez", 24);
//                    break;
//                case 6:
//                    mt.delete(2);
//                    break;
//                case 7:
//                    System.exit(0);
//            }
//
//        } while (op < 7);
    }
    
}
