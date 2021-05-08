package com.andres.sv.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andres.sv.Negocio.clsValidarLogin;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLogin() {
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

		String btncerrar = request.getParameter("btncerrar");
		if (btncerrar != null) {
			response.sendRedirect("index.jsp");
			session.invalidate();
		} else {
			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("password");

			clsValidarLogin clsLogin = new clsValidarLogin();
			int access = clsLogin.AccesoLogin(usuario, contrasenia);

			if (access == 1) {
				response.sendRedirect("VerificarDUI.jsp");
				System.out.println("> Usted ha accedido a la verificacion");
				session.setAttribute("usuario", access);
			} else {
				response.sendRedirect("Error.jsp");
				System.out.println("> No se econto el usuario.");
			}
		}
	}

}
