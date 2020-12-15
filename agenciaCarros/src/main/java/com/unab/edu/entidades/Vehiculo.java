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
public class Vehiculo {
    private int Id;
    private int Puertas;
    private String Chasis;
    private String Color;
    private String Emision;
    private String Motor;
    private double PrecioAdq;
    private Proveedor Proveedor;
    private Modelo Modelo;
    private int Existencia;
}
