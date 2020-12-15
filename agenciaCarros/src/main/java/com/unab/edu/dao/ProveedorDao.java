/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Marca;
import com.unab.edu.entidades.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ProveedorDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    //METODOS DE ACCESO A LA BASE DE DATOS
    public void agregarProveedor(Proveedor prov) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Proveedor(?,?,?,?,?,?,?)");
            statement.setString("pNombre", prov.getNombre());
            statement.setString("pContacto", prov.getContacto());
            statement.setString("pDireccion", prov.getDireccion());
            statement.setString("pTelefono", prov.getTelefono());
            statement.setString("pCorreo", prov.getCorreo());
            statement.setString("pNit", prov.getNit());
            statement.setString("pNrc", prov.getNrc());
            //ejecutamos la consulta
            statement.execute();
            int IdGenerado = 0;

            CallableStatement statement2 = con.prepareCall("select max(idProveedor) as IdProveedor from proveedor");
            ResultSet res = statement2.executeQuery();
            if (res.next()) {
                IdGenerado = res.getInt("IdProveedor");
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar el Id del Proveedor");
            }
            //JOptionPane.showMessageDialog(null,IdGenerado);
            if (IdGenerado != 0) {
                for (var iterar : prov.getMarcas()) {
                    CallableStatement statement3 = con.prepareCall("call sp_i_ProveedorMarca(?,?)");
                    statement3.setInt("pIdProveedor", IdGenerado);
                    statement3.setInt("pIdMarca", iterar.getId());
                    //ejecutamos la consulta
                    //JOptionPane.showMessageDialog(null,IdGenerado+"  "+iterar.getId());
                    statement3.execute();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar las Marcas");
            }

            con.close();
            JOptionPane.showMessageDialog(null, "Datos almacenados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");

        }
    }

    public void actualizarProveedor(Proveedor prov) {
        try {
            CallableStatement statement = con.prepareCall("call sp_u_Proveedor(?,?,?,?,?,?,?,?)");
            statement.setInt("pIdProveedor", prov.getId());
            statement.setString("pNombre", prov.getNombre());
            statement.setString("pContacto", prov.getContacto());
            statement.setString("pDireccion", prov.getDireccion());
            statement.setString("pTelefono", prov.getTelefono());
            statement.setString("pCorreo", prov.getCorreo());
            statement.setString("pNit", prov.getNit());
            statement.setString("pNrc", prov.getNrc());
            //ejecutamos la consulta
            statement.execute();
            CallableStatement statement2 = con.prepareCall("delete from proveedormarca where idProveedor=" + prov.getId() + ";");
            statement2.execute();
            //JOptionPane.showMessageDialog(null,IdGenerado);
            if (prov.getId() != 0) {
                for (var iterar : prov.getMarcas()) {
                    CallableStatement statement3 = con.prepareCall("call sp_i_ProveedorMarca(?,?)");
                    statement3.setInt("pIdProveedor", prov.getId());
                    statement3.setInt("pIdMarca", iterar.getId());
                    //ejecutamos la consulta
                    //JOptionPane.showMessageDialog(null,IdGenerado+"  "+iterar.getId());
                    statement3.execute();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar las Marcas");
            }

            con.close();
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos" + e);

        }
    }

    public ArrayList<Proveedor> mostrarProveedores() {
        var listado = new ArrayList<Proveedor>();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Proveedor;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(res.getInt("idProveedor"));
                prov.setNombre(res.getString("Nombre"));
                prov.setContacto(res.getString("Contacto"));
                prov.setDireccion(res.getString("Direccion"));
                prov.setTelefono(res.getString("Telefono"));
                prov.setNit(res.getString("Nit"));
                prov.setCorreo(res.getString("Correo"));
                prov.setNrc(res.getString("Nrc"));
                listado.add(prov);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Proveedores " + e);
        }
        return listado;
    }

    public ArrayList<Marca> Marcas(int IdPoveedor) {
        var listado = new ArrayList<Marca>();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_ProveedorMarca(?);");
            statement.setInt("pIdProveedor", IdPoveedor);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Marca marca = new Marca();
                marca.setId(res.getInt("idMarca"));
                marca.setNombreMarca(res.getString("Nombre"));
                listado.add(marca);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las marcas" + e);
        }
        return listado;
    }

    public void elimiarProveedor(int IdProveedor) {
        try {
            CallableStatement statement = con.prepareCall("delete from proveedormarca where idProveedor=" + IdProveedor + ";");
            if (statement.executeUpdate() == 1) {
                CallableStatement statement2 = con.prepareCall("call sp_d_Proveedor(?);");
                statement2.setInt("pIdProveedor", IdProveedor);
                if (statement2.executeUpdate()== 1) {
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error eliminando el Proveedor!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error eliminando las dependencias del Proveedor!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e);
        }
    }
    
    public ArrayList<Proveedor> mostrarProveedoresMarca(int IdMarca){
        ArrayList<Proveedor> listadoProv = new ArrayList<Proveedor>();
        try {
            CallableStatement state = con.prepareCall("call sp_s_MarcaProveedor(?);");
            state.setInt("pIdMarca", IdMarca);
             ResultSet res = state.executeQuery();
            while (res.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(res.getInt("idProveedor"));
                prov.setNombre(res.getString("Nombre"));
                listadoProv.add(prov);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los Proveedores " + e);
        }
        return listadoProv;
    }
}
