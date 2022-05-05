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
    
      public void actualizarEliminarRegistros (String tabla, String valoresCamposNuevos, String condicion){
    //Cargar la conexion
    ConexionCRUD conectar = new ConexionCRUD();
    Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;
            //Verificar que valoresCamposNuevos venga vacia y asi selecionar si es borrar o actualizar registro
            if (valoresCamposNuevos.isEmpty()) {
                sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
            } else {
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
      
      public void desplegarRegistro(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
    //Cargar la conexion
    ConexionCRUD conectar = new ConexionCRUD();
    Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;
            if (condicionBuscar.equals("")) {
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
            } else {
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            //Le indicamos que ejecute la consulta de la tabla y le pasamos por argumentos nuestra sentencia
            try (ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if (miResultSet.next()) { //Ubica el cursor en la primera fila de la tabla de resultado
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.print("<<REGISTROS ALMACENADOS>>");
                    System.out.println();
                    for (int i = 1; i <= numColumnas; i++) {
                        //Muestra los titulos de las columnas y %-20\t indica la separacion entre columnas
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }
                    System.out.println();
                    do {                        
                        for (int i = 1; i <=numColumnas ; i++) {
                            System.out.printf("%-20s\t", miResultSet.getObject(i));   
                        }
                        System.out.println();
                    } while (miResultSet.next());
                    System.out.println();
                } else {
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close();//Cerrar el ResultSet
            } finally{
                //Cerrar el Statement y la Conexion; se cierran en orden inverso de como se han abierto
                stmt.close();
                cone.close();
            }
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: "+ ex.getMessage());
        }
    }
}
