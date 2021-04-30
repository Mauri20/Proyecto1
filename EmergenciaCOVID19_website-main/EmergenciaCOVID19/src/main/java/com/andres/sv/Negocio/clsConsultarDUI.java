package com.andres.sv.Negocio;

import com.andres.sv.DAO.ClsBeneficiario;
import com.andres.sv.Entidades.Beneficiario;
import com.andres.sv.Entidades.Persona;

public class clsConsultarDUI {

	public int SoyBeneficiario(Persona person) {
			
		int soy = 0;
		
		ClsBeneficiario clsBeneficiario = new ClsBeneficiario();
		
		var beneficiario = clsBeneficiario.ObtenerBeneficiario(person);
		
		if(beneficiario == true) {
			soy = 1;
		}
		
		return soy;
	}
}
