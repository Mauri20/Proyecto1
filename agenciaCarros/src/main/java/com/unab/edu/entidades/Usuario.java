/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import lombok.*;

/**
 *
 * @author kevin
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Empleado {
    
    
    private int idUsuario;
    private String Usuario;
    private String Pass;
    private String Tipo;
   
    
    
}
