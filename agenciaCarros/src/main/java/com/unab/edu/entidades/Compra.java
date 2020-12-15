/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import java.util.ArrayList;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Mauricio
 */
@Data
public class Compra {
    int IdCompra;
    String Codigo;
    Date Fecha;
    String Tipo;
    Double Subtotal;
    Double Iva;
    Double Total;
    ArrayList<DetalleCompra> DetalleCompra;
    Usuario usuario;
}
