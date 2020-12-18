//Review ready
package com.unab.edu.dao;
import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class UsuarioDao {
    
    //CONEXION A LA BASE DE DATOS 
    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();
    
    
    //CONSULTAS A LA BASE DE DATOS 
    
    
    
    //SP_I_USUARIO--COMPLETADO!
    public void agregarUsuario(Usuario usuario){
      try {
            CallableStatement statement = con.prepareCall("call SP_I_Usuario(?,?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", usuario.getPass());
            statement.setString("pTipo", usuario.getTipo());
            statement.setInt("pId", usuario.getId());  
            
    
            statement.execute();
            con.close();
            
            
            JOptionPane.showMessageDialog(null, "DATOS REGISTRADOS!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS");
        }         
    }
    
    
    
    
    
    //SP_U_USUARIO--COMPLETADO!
    public void actualizarUsuario(Usuario usuario) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Usuario(?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pTipo", usuario.getTipo());
            statement.setInt("pId", usuario.getId());  
            //System.out.println(usuario.getIdUsuario()+"-"+usuario.getUsuario()+"-"+usuario.getPass()+"-"+usuario.getTipo()+"-"+usuario.getId());
            int i =statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADOOOOOOOO!");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
        }
    }
    public void actualizarUsuario(Usuario usuario, String passUdate) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Usuario2(?,?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", passUdate);
            statement.setString("pTipo", usuario.getTipo());
            statement.setInt("pId", usuario.getId());  
            //System.out.println(usuario.getIdUsuario()+"-"+usuario.getUsuario()+"-"+usuario.getPass()+"-"+usuario.getTipo()+"-"+usuario.getId());
            int i =statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
        }
    }
       
    //SP_D_USUARIO--COMPLETADO!
    public void eliminarUsuario(Usuario usuario) {
        
         try {
            CallableStatement statement = con.prepareCall("call SP_D_Usuario(?);");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
          
            statement.execute();
            con.close();
            
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");                      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INTENTAR ELIMINAR LOS DATOS" + e);
        }
    }
    
    //SP_S_USUARIO--COMPLETADO!
     public ArrayList<Usuario> MostrarUsuario() {
        var listado = new ArrayList<Usuario>();
        
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Usuario;");
            ResultSet us = statement.executeQuery();
            
            while (us.next()) {
                
                Usuario usua = new Usuario();
                
                usua.setIdUsuario(us.getInt("idUsuario"));
                usua.setUsuario(us.getString("Usuario"));
                usua.setPass(us.getString("Pass"));
                usua.setTipo(us.getString("Tipo"));
                usua.setId(us.getInt("idEmpleado"));
                usua.setNombre(us.getString("Nombre"));
                              
                listado.add(usua);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATOS DE USUARIO NO CARGADOS " + e);
        }

        return listado;
    }
     
     //SP_S_INGRESAR--COMPLETADO!:para el ingreso
     public Usuario Login(Usuario user) {
        Usuario usu = new Usuario();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Ingresar(?,?,?);");
            
            statement.setString("pUsuario", user.getUsuario());
            statement.setString("pPass", user.getPass());
            statement.setString("pTipo", user.getTipo());      
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usu.setIdUsuario(result.getInt("idUsuario"));
                usu.setUsuario(result.getString("Usuario"));
                usu.setPass(result.getString("Pass"));
                usu.setTipo(result.getString("Tipo"));                        
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Credenciales no válidas" + e);
        }
        return usu;
    }
    
    
}
