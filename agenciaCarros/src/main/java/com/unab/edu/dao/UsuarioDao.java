/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Usuario;
import java.sql.Connection;

/**
 *
 * @author kevin
 */
public class UsuarioDao {
    
    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();
    
    public void agregarUsuario(Usuario usuario){
        
        
        
    }
    
    
    
    
}
