/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import lombok.Data;

/**
 *
 * @author Mauricio
 */
@Data
public class DetalleCompra {
    private int IdDetalleCompra;
    private int Cantidad;
    private Vehiculo Vehiculo;
}
