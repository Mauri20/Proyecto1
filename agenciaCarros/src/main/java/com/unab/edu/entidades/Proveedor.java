/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author Mauricio
 */
@Data
public class Proveedor {
    private int Id;
    private String Nombre;
    private String Contacto;
    private String Direccion;
    private String Telefono;
    private String Correo;
    private String Nit;
    private String Nrc;
    private ArrayList<Marca> Marcas;
}
