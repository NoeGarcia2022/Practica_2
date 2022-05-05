package crud_estudiante;

import java.sql.*;

public class ConexionCRUD {
    /*Ruta de la base de datos del servidor 127.0.0.1, el puerto 3306 y el nombre
    de la base de datos bd_recurso_humano
    */
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_estudiantes";
    //Nombre del usuario (root por defecto) de la base de datos
    private final String usuario = "root";
    //Clave del usuario de la base de datos
    private final String clave="";
    //Libreria de MySQL
    private final String driverConector = "com.mysql.jdbc.Driver";
    //Objeto de la clase Connection del paquete java.sql
    private static Connection conexion;
    
    //ESTABLECER LOS METODOS PARA LA CONEXION A LA BD CON LAS VARIABLES (CONSTANTES) ANTERIORES
    
    public ConexionCRUD(){
        try {
            Class.forName(driverConector);//Levantar el driver
            //Establecer conexion
            conexion=DriverManager.getConnection(servidor, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion fallida! Error!: "+ e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion; //Devuelve el objeto conexion
    }
    
     public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
    //Cargar la conexion
    ConexionCRUD conectar = new ConexionCRUD();
    Connection cone = conectar.getConnection();
        try {
            //definir la sentecia SQL
            String sqlQueryStmt = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUES (" + valoresCampos + ");";
            //Establecemos la comunicaion entre nuestra aplicion java y la base de datos
            Statement stmt;//Envia sentencias sql a la base dde datos
            stmt=cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);//Ejecutar la sentencia sql
            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
