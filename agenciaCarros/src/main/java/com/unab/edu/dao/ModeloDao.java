package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Modelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto
 */
public class ModeloDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    public void agregarModelo(Modelo modelo) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_Modelo(?)");
            statement.setString("MNombre", modelo.getNombreModelo());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos almacenados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");

        }

    }
    
     public void actualizarModelo(Modelo modelo) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Modelo(?,?)");
            statement.setInt("MIdModelo", modelo.getIdModelo());
            statement.setString("MNombre", modelo.getNombreModelo());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");

        }

    }
     
     
     public void eliminarModelo(Modelo modelo) {
        try {
            CallableStatement statement = con.prepareCall("call SP_D_Modelo(?)");
            statement.setInt("MIdModelo", modelo.getIdModelo());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Datos eliminados correntamente");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }
     
     public ArrayList<Modelo> MostrarModelos() {
        var listado = new ArrayList<Modelo>();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Modelo()");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Modelo model= new Modelo();
                model.setId(res.getInt("idModelo"));
                model.setNombreModelo(res.getString("Nombre"));

                listado.add(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Datos " + e);
        }

        return listado;
    }
}
