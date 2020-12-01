


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
    
    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();
    
    
    //Consultas a la base de datos 
    public void agregarUsuario(Usuario usuario){
      try {
            CallableStatement statement = con.prepareCall("call SP_I_Usuario(?,?,?,?)");
            
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", usuario.getPass());
            statement.setInt("pTipo", usuario.getTipo());
            statement.setInt("pId", usuario.getId());                      
    
            statement.execute();
            con.close();
            
            JOptionPane.showMessageDialog(null, "DATOS REGISTRADOS!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS");
        }         
    }
    
    
    
    public void actualizarUsuario(Usuario usuario) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Usuario(?,?,?,?,?)");
            
            statement.setInt("pIdusu", usuario.getIdUsuario());  
            statement.setString("pUsuario", usuario.getUsuario());
            statement.setString("pPass", usuario.getPass());
            statement.setInt("pTipo", usuario.getTipo());
            statement.setInt("pId", usuario.getId());  
           
            statement.execute();
            con.close();
            
            JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
        }
    }
    
    
    
    
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
    
    
    
     public ArrayList<Usuario> MostrarUsuario() {
        var listado = new ArrayList<Usuario>();
        
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Usuario;");
            ResultSet us = statement.executeQuery();
            
            while (us.next()) {
                Usuario usua = new Usuario();
                
                usua.setIdUsuario(us.getInt("idUsu"));
                usua.setUsuario(us.getString("Usuario"));
                usua.setPass(us.getString("Pass"));
                usua.setTipo(us.getInt("Tipo"));
               
                
                
                listado.add(usua);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATOS DE USUARIO NO CARGADOS " + e);
        }

        return listado;
    }
     public Usuario Login(Usuario user) {
        Usuario usu = new Usuario();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Ingresar(?,?,?);");
            statement.setString("pUsuario", user.getUsuario());
            statement.setString("pPass", user.getPass());
            statement.setInt("pTipo", user.getTipo());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPass(res.getString("Pass"));
                usu.setTipo(res.getInt("Tipo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario" + e);
        }
        return usu;
    }
    
    
}
