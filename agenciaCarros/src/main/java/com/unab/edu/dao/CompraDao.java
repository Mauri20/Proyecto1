/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class CompraDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    public int traerCodigo(){
        int codigo=0;
        try {
            CallableStatement state = con.prepareCall("select codigo from compra where idCompra=(select max(idCompra) from compra)");
            ResultSet res= state.executeQuery();
            if(res.next()){
                codigo=Integer.parseInt(res.getString("codigo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: --"+e);
        }
        
        return codigo;
    }
    public void agregarCompra(Compra compra) {
        try {
            CallableStatement state = con.prepareCall("call sp_i_Compra(?,?,?,?,?)");
            state.setString("pCodigo", compra.getCodigo());
            state.setDate("pFecha", new java.sql.Date(compra.getFecha().getTime()));
            state.setString("pTipo", compra.getTipo());
            state.setDouble("pTotal", compra.getTotal());
            state.setInt("pIdUsuario", compra.getUsuario().getIdUsuario());

            if (state.executeUpdate() == 1) {
                int IdGenerado = 0;
                CallableStatement state2 = con.prepareCall("select max(idCompra) as idCompra from compra");
                ResultSet res = state2.executeQuery();
                if (res.next()) {
                    IdGenerado = res.getInt("idCompra");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al generar el Id de la Compra");
                }
                if (IdGenerado != 0) {
                    CallableStatement state3 = con.prepareCall("insert into detallecompra(Cantidad,idVehiculo,idCompra) values(?,?,?)");
                    for (var iterar : compra.getDetalleCompra()) {
                        state3.setInt(1, iterar.getCantidad());
                        state3.setInt(2, iterar.getVehiculo().getId());
                        state3.setInt(3, IdGenerado);
                        //ejecutar
                        state3.executeUpdate();
                    }
                    CallableStatement state4 = con.prepareCall("update inventario set existencia=existencia+? where idVehiculo=?");
                   
                    for (var iterar : compra.getDetalleCompra()) {
                        state4.setInt(1, iterar.getCantidad());
                        state4.setInt(2, iterar.getVehiculo().getId());
                        //Ejecutar
                        state4.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null,"Compra registrada");
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrió un error al incorporar el IdCompra");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar la Compra");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar ---"+e);
        }
    }
}
