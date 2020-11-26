package com.unab.edu.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import lombok.Data;

/**
 *
 * @author
 */
@Data
public class Cliente {
    private int IdCliente;
    private String Nombre;
    private String Tipo;
    private String Contacto;
    private String Telefono;
    private String Direccion;
    private String Correo;
    private String Dui;
    private String Nit;
    private String Nrc;
    
    
}
