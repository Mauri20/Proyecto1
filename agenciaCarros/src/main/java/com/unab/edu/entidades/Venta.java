/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Oscar
 */
@Data
public class Venta {
    
    private int  idVenta;
    private  String Codigo;
    private Date Fecha;
    private  double Subtotal;
    private double Iva;
    private double Total;
    private String Estado;
    private  int idCliente;
    private int idUsuario;
    
    
           

    
    
    
}
