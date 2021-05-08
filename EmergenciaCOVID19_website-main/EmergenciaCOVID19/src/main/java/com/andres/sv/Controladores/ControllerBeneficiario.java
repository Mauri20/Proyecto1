package com.andres.sv.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andres.sv.DAO.ClsBeneficiario;
import com.andres.sv.Entidades.Beneficiario;
import com.andres.sv.Entidades.Persona;
import com.andres.sv.Negocio.clsConsultarDUI;
import com.andres.sv.Negocio.clsValidarLogin;
import com.google.gson.Gson;

/**
 * Servlet implementation class ControllerBeneficiario
 */
public class ControllerBeneficiario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerBeneficiario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession(true);
		String soyBenef = request.getParameter("soybeneficiario");
		String noBenef = request.getParameter("nosoybeneficiario");

		String fullname = "";

		if (soyBenef != null || noBenef != null) {
			response.sendRedirect("index.jsp");
			session.invalidate();
		} else {
			String dui = request.getParameter("dui");
			Persona person = new Persona();
			person.setDUI(dui);
			clsConsultarDUI consultaDUI = new clsConsultarDUI();
			ClsBeneficiario clsBeneficiario = new ClsBeneficiario();

			fullname = clsBeneficiario.MostrarBeneficiario(person);

			int soybeneficiario = consultaDUI.SoyBeneficiario(person);

			if (soybeneficiario == 0) {
				response.sendRedirect("NoSoyBeneficiario.jsp");
				session.setAttribute("nobeneficiario", soybeneficiario);

			} else if (soybeneficiario == 1) {

				response.sendRedirect("SoyBeneficiario.jsp");
				session.setAttribute("beneficiario", soybeneficiario);
				session.setAttribute("fullname", fullname);
				System.out.println("Nombre del Beneficiario: " + fullname);
			}
		}
	}
}
