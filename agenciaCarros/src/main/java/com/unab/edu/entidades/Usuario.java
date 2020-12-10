//Review --Ready
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
