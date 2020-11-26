package com.unab.edu.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class ClienteDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    //METODOS DE ACCESO A LA BASE DE DATOS
    public void AgregarCliente(Cliente cliente) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_Cliente(?,?,?,?,?,?,?,?,?)");
            statement.setString("CNombre", cliente.getNombre());
            statement.setString("CTipo", cliente.getTipo());
            statement.setString("CContacto", cliente.getContacto());
            statement.setString("CTelefono", cliente.getTelefono());
            statement.setString("CDireccion", cliente.getDireccion());
            statement.setString("CCorreo", cliente.getCorreo());
            statement.setString("CDui", cliente.getDui());
            statement.setString("CNit", cliente.getNit());
            statement.setString("CNrc", cliente.getNrc());
            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Cliente Guardado Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar a cliente");

        }

    }

    public void ActualizarCliente(Cliente cliente) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Cliente(?,?,?,?,?,?,?,?,?,?)");
            statement.setString("CNombre", cliente.getNombre());
            statement.setInt("CIdCliente", cliente.getIdCliente());
            statement.setString("CTipo", cliente.getTipo());
            statement.setString("CContacto", cliente.getContacto());
            statement.setString("CTelefono", cliente.getTelefono());
            statement.setString("CDireccion", cliente.getDireccion());
            statement.setString("CCorreo", cliente.getCorreo());
            statement.setString("CDui", cliente.getDui());
            statement.setString("CNit", cliente.getNit());
            statement.setString("CNrc", cliente.getNrc());
            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Cliente Actualizado Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar a Cliente");

        }

    }

    public void EliminarCliente(Cliente cliente) {
         try {
            CallableStatement statement = con.prepareCall("call SP_D_Cliente(?);");
            statement.setInt("CIdCliente", cliente.getIdCliente());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Cliente eliminado correntamente");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar a cliente" + e);

        }
    }

    public ArrayList<Cliente> MostrarClientes() {
        var listado = new ArrayList<Cliente>();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Cliente;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Cliente clientes = new Cliente();
                clientes.setIdCliente(res.getInt("idcliente"));
                clientes.setNombre(res.getString("Nombre"));
                clientes.setTipo(res.getString("Tipo"));
                clientes.setContacto(res.getString("Contacto"));
                clientes.setTelefono(res.getString("Telefono"));
                clientes.setDireccion(res.getString("Direccion"));
                clientes.setCorreo(res.getString("Correo"));
                clientes.setDui(res.getString("Dui"));
                clientes.setNit(res.getString("Nit"));
                clientes.setNrc(res.getString("Nrc"));
                listado.add(clientes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar los clientes debido a un error en el sistema" + e);
        }

        return listado;
    }
}
