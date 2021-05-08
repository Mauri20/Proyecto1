package com.andres.sv.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.sv.Entidades.Persona;
import com.andres.sv.Conexion.ConexionBD;

public class ClsPersona {

	ConexionBD claseConectar = new ConexionBD();
    Connection conectar = claseConectar.RetornarConexion();
    
	public boolean LoguinPersona(String Usuario, String Password) {

        ArrayList<Persona> ListadoUSUARIOPASS = new ArrayList<>();
        ArrayList<Persona> ListarContra = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call Sp_S_Login(?,?)");
            Statement.setString("PUsuario", Usuario);
            Statement.setString("PContrasenia", Password);
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {

                Persona person = new Persona();
                person.setUsuario(resultadoConsulta.getString("Usuario"));
                person.setContrasenia(resultadoConsulta.getString("Contrasenia"));
                ListadoUSUARIOPASS.add(person);
            }

            String usuarioBD = null;
            String contraseniaBD = null;
            for (var iterar : ListadoUSUARIOPASS) {

            	usuarioBD = iterar.getUsuario();
            	contraseniaBD = iterar.getContrasenia();
            }

            CallableStatement st2 = conectar.prepareCall("call Sp_S_CripPersona(?)");
            st2.setString("PContrasenia", Password);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Persona percrip = new Persona();
                percrip.setContrasenia(rs2.getNString("crip"));
                ListarContra.add(percrip);
            }

            String passcrip = null;
            for (var iterar : ListarContra) {

                passcrip = iterar.getContrasenia();
                Password = passcrip;
            }

            if (usuarioBD != null && contraseniaBD != null) {
                if (usuarioBD.equals(Usuario) && contraseniaBD.equals(Password)) {
                    return true;
                }
            }
            conectar.close();

        } catch (Exception e) {
            System.out.println("> Ha ocurrido un error, vengo de ClsPersona. \n" + e);
        }
        return false;
    }
}
