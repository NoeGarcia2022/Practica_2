
package crud_estudiante;

import java.sql.SQLException;
import java.util.Scanner;


public class Update {
    Update() throws SQLException {
        Scanner leer = new Scanner(System.in);
        Estudiante est = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<<Actualizar Registros>>");
        
        System.out.println("Ingresar id del registro a modificar:  ");
        est.setIdEstudiante(leer.nextInt());
        
        String tablaBuscar = "tb_datos_estudiantes";
        String campoBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + est.getIdEstudiante();
        utilerias.desplegarRegistro(tablaBuscar, campoBuscar, condicionBuscar);
        
        System.out.println("Carnet:");
         est.setCarnetEstudiante(leer.nextLine());
         
         System.out.println("Nombres:");
         est.setNomEstudiante(leer.nextLine());
         
          System.out.println("Apellidos");
         est.setApeEstudiante(leer.nextLine());
         
         System.out.println("Edad:");
         est.setEdadEstudiante(leer.nextInt());
        
        String tabla = "tb_datos_estudiantes";
        String camposValoresNuevos = "carnet_estudiante = ´" + est.getCarnetEstudiante() + "', nom_estudiante = '"
                + est.getNomEstudiante() + "', ape_estudiante = '" + est.getApeEstudiante() + "', edad_estudiante = '"
                + est.getEdadEstudiante() + "'";
    
}
}