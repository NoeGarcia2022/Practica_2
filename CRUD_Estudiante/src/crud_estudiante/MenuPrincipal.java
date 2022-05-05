
package crud_estudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    //throws especifica el tipo de excepcion que puede ocasionar
    public static void main(String[] args) throws SQLException {
        desplegarMenu();
        
    }
    
    public static void desplegarMenu() throws SQLException {
        Scanner opcionSelecionada = new Scanner(System.in);
        String opcionMenu;
        //Menu a desplegar
        System.out.println("************************************");
        System.out.println("|     CRUD DE JAVA EN CONSOLA      |");
        System.out.println("************************************");
        System.out.println("| Opciones:                        |");
        System.out.println("|        1. Crear registros        |");
        System.out.println("|        2. Consultar registros    |");
        System.out.println("|        3. Actualizar registros   |");
        System.out.println("|        4. Eliminar Registros     |");
        System.out.println("|        5. Salir                  |");
        System.out.println("***********************************");
        System.out.print("Seleccionar opcion: ");
        opcionMenu = opcionSelecionada.next();
        
        
    }
 }  