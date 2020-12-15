/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class VehiculoDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    public void agregarVehiculo(Vehiculo vehiculo) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Vehiculo(?,?,?,?,?,?,?,?);");
            statement.setInt("pPuertas", vehiculo.getPuertas());
            statement.setString("pChasis", vehiculo.getChasis());
            statement.setString("pColor", vehiculo.getColor());
            statement.setString("pEmision", vehiculo.getEmision());
            statement.setString("pMotor", vehiculo.getMotor());
            statement.setDouble("pPrecioAdq", vehiculo.getPrecioAdq());
            statement.setInt("pIdModelo", vehiculo.getModelo().getIdModelo());
            statement.setInt("pIdProveedor", vehiculo.getProveedor().getId());
            if (statement.executeUpdate() == 1) {
                int IdGenerado = 0;
                CallableStatement statement2 = con.prepareCall("select max(idVehiculo) as idVehiculo from vehiculo");
                ResultSet res = statement2.executeQuery();
                if (res.next()) {
                    IdGenerado = res.getInt("idVehiculo");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al generar el Id del Vehiculo");
                }
                if(IdGenerado!=0){
                    String descripcion="Modelo "+vehiculo.getModelo().getNombreModelo()+", color "+vehiculo.getColor()+", de "+vehiculo.getPuertas()+" puertas";
                    String existencia="0";
                    CallableStatement state3 =con.prepareCall("insert into inventario(Descripcion, Existencia, idVehiculo) values(?,?,?)");
                    state3.setString(1, descripcion);
                    state3.setString(2, existencia);
                    state3.setInt(3, IdGenerado);
                    state3.execute();
                }   
                JOptionPane.showMessageDialog(null, "Vehiculo registrado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al ejecutar el guardado del Vehiculo");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " + e);
        }

    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        try {
            CallableStatement statement = con.prepareCall("call sp_u_Vehiculo(?,?,?,?,?,?,?,?,?);");
            statement.setInt("pIdVehiculo", vehiculo.getId());
            statement.setInt("pPuertas", vehiculo.getPuertas());
            statement.setString("pChasis", vehiculo.getChasis());
            statement.setString("pColor", vehiculo.getColor());
            statement.setString("pEmision", vehiculo.getEmision());
            statement.setString("pMotor", vehiculo.getMotor());
            statement.setDouble("pPrecioAdq", vehiculo.getPrecioAdq());
            statement.setInt("pIdModelo", vehiculo.getModelo().getIdModelo());
            statement.setInt("pIdProveedor", vehiculo.getProveedor().getId());
            if (statement.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Vehiculo actualizado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la actualización del Vehiculo");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        try {
            CallableStatement statement = con.prepareCall("call sp_d_Vehiculo(?);");
            statement.setInt("pIdVehiculo", vehiculo.getId());
            if (statement.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Vehiculo eliminado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la eliminación del Vehiculo");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e);
        }
    }

    public ArrayList<Vehiculo> mostrarVehiculos() {
        ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>();
        try {
            CallableStatement consulta = con.prepareCall("call sp_s_Vehiculos();");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Vehiculo carro = new Vehiculo();
                Modelo modelo = new Modelo();
                Proveedor prov = new Proveedor();
                carro.setId(res.getInt("idVehiculo"));
                carro.setPuertas(res.getInt("Puertas"));
                carro.setChasis(res.getString("NumChasis"));
                carro.setColor(res.getString("Color"));
                carro.setEmision(res.getString("Emision"));
                carro.setMotor(res.getString("Motor"));
                carro.setPrecioAdq(res.getDouble("PrecioAdq"));
                carro.setExistencia(res.getInt("Existencia"));

                modelo.setIdModelo(res.getInt("idMarcaModelo"));
                modelo.setNombreModelo(res.getString("Modelo"));
                modelo.setId(res.getInt("idMarca"));
                modelo.setNombreMarca(res.getString("Marca"));

                carro.setModelo(modelo);

                prov.setId(res.getInt("idProveedor"));
                prov.setNombre(res.getString("Nombre"));

                carro.setProveedor(prov);

                listado.add(carro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron Cargar los Vehiculos " + e);
        }
        return listado;
    }

//    public Vehiculo buscarVehiculo(int Modelo, int Proveedor) {
//        Vehiculo carro = new Vehiculo();
//        try {
//            CallableStatement consulta = con.prepareCall("call sp_s_Vehiculo();");
//            ResultSet res = consulta.executeQuery();
//            while (res.next()) {
//                Modelo modelo = new Modelo();
//                Proveedor prov = new Proveedor();
//                carro.setId(res.getInt("idVehiculo"));
//                carro.setPuertas(res.getInt("Puertas"));
//                carro.setChasis(res.getString("NumChasis"));
//                carro.setColor(res.getString("Color"));
//                carro.setEmision(res.getString("Emision"));
//                carro.setMotor(res.getString("Motor"));
//                carro.setPrecioAdq(res.getDouble("PrecioAdq"));
//
//                modelo.setIdModelo(res.getInt("idMarcaModelo"));
//                modelo.setNombreModelo(res.getString("Modelo"));
//                modelo.setId(res.getInt("idMarca"));
//                modelo.setNombreMarca(res.getString("Marca"));
//
//                carro.setModelo(modelo);
//
//                prov.setId(res.getInt("idProveedor"));
//                prov.setNombre(res.getString("Nombre"));
//
//                carro.setProveedor(prov);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudieron Cargar los Vehiculos " + e);
//        }
//        return carro;
//    }
}
