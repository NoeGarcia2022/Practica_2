
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
    
}
