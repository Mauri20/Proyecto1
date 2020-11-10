package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Marca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto
 */
public class MarcaDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    public void agregarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_Marca(?)");
            statement.setString("MNombre", marca.getNombre());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos almacenados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");

        }

    }

    public void actualizarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_Marca(?,?)");
            statement.setInt("MIdMarca", marca.getId());
            statement.setString("MNombre", marca.getNombre());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");

        }

    }

    public void eliminarMarca(Marca marca) {
        try {
            CallableStatement statement = con.prepareCall("call SP_D_Marca(?);");
            statement.setInt("MIdMarca", marca.getId());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Datos eliminados correntamente");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }

    public ArrayList<Marca> MostrarMarcas() {
        var listado = new ArrayList<Marca>();
        try {
            CallableStatement statement = con.prepareCall("call SP_S_Marca;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Marca marc = new Marca();
                marc.setId(res.getInt("idMarca"));
                marc.setNombre(res.getString("Nombre"));

                listado.add(marc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Datos " + e);
        }

        return listado;
    }
}
