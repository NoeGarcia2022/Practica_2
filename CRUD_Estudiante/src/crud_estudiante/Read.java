
package crud_estudiante;

import java.sql.SQLException;


public class Read {
    public Read() throws SQLException{
        System.out.println("<<CONSULTA DE REGISTROS>>");
        mostrarResultados();//Llamar el metodo dentro de esta clase 
    
}
    }

private void mostrarResultados() throws SQLException{
        try{
            ConexionCRUD utilerias=new ConexionCRUD();
            String tabla="tb_datos_estudiantes";
            String camposTabla="*";
            //Conexion se envia vacia para indicar que todos los registros se necesitan mostrar

            String condicionBusqueda="";
            //Metodo que realiza la busqueda
            utilerias.desplegarRegistro(tabla, camposTabla, condicionBusqueda);


}catch(SQLException ex){
            
