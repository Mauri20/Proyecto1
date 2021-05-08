package com.andres.sv.Negocio;

import com.andres.sv.DAO.ClsPersona;

public class clsValidarLogin {

	public int AccesoLogin(String Usuario, String Contrasenia) {
		
		int Acceso = 0;
		ClsPersona clsPersona = new ClsPersona();
		
		var validar = clsPersona.LoguinPersona(Usuario, Contrasenia);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}
}
