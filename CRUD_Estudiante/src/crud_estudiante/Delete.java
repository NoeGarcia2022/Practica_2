
package crud_estudiante;

import java.sql.SQLException;
import java.util.Scanner;


public class Delete {
    Delete () throws SQLException {
    Scanner leer = new Scanner(System.in);
    ConexionCRUD utilerias = new ConexionCRUD();
    
        System.out.println("<<ELIMINAR REGISTROS>>");
        
        System.out.println("Ingresar el ID del registro:");
        String idEstudianteEliminar=leer.next();
        //reingreso de datos para actualizar 
        String tabla="tb_datos_estudiantes";
        String campos="*";
        String condicion="id_estudiante="+idEstudianteEliminar;
        utilerias.desplegarRegistro(tabla,campos,condicion);
         
        System.out.println("Presionar <<Y>> para confirmar:");
        String confirmarBorrar=leer.next();
        
        if ("Y".equals(confirmarBorrar)){
            /*Se le deja vacio para el metodo actualizarEliminarRegistro
              envie solamente los parametros de tabla y condicion y poder eliminar*/
              String valoresCamposNuevos = "";
              
    utilerias.actualizarEliminarRegistros(tabla,valoresCamposNuevos,condicion);
            System.out.println("Registro borrado satisfactoriamente!");
    }
    
    MenuPrincipal.desplegarMenu();
    }
}
