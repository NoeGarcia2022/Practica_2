
package crud_estudiante;

import java.sql.SQLException;
import java.util.Scanner;


public class Create {
    Create () throws SQLException {
        Scanner leer =new  Scanner(System.in);
        Estudiante est= new Estudiante();
        
        System.out.println("<<CREAR REGISTRO>>");
        
        System.out.println("Carnet:");
        est.setCarnetEstudiante(leer.nextLine());
        
        System.out.println("Nombres:");
        est.setNomEstudiante(leer.nextLine());
        
        System.out.println("Apellidos:");
        est.setApeEstudiante(leer.nextLine());
        
        System.out.println("Edad:");
        est.setEdadEstudiante(leer.nextInt());
         
        String tabla="tb_datos_estudiantes";
        String camposTabla="carnet_estudiante,nom_estudiante,ape_estudiante,edad_estudiante";
        String valoresCampos="'"+est.getCarnetEstudiante()+"','"+est.getNomEstudiante()+"','"+
         est.getApeEstudiante()+"','"+est.getEdadEstudiante()+ "'"; //Esta linea es continua a la anterior
        
        //Instancia u objeto de la clase ConexionCRUD
        ConexionCRUD utilerias =new ConexionCRUD();
        
        //Se envian los parametros necesarios para guardar el registro al metodo guardarRegistros
        utilerias.guardarRegistros(tabla,camposTabla,valoresCampos);
        
        MenuPrincipal.desplegarMenu(); //Llama al metodo del menu principal
        
    }
        
}
