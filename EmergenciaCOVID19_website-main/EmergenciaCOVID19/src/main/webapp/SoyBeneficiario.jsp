<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Emergencia COVID-19</title>
<link rel="icon" href="Imagenes/virus.ico">
<link rel="stylesheet" href="Styles/style_soybeneficiario.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body class="bbody">
	<%
	HttpSession sesion = (HttpSession) request.getSession();
	String usuSession = String.valueOf(sesion.getAttribute("beneficiario"));
	String fullname = String.valueOf(sesion.getAttribute("fullname"));
	System.out.println("Beneficiario: " + usuSession);

	if (usuSession.equals(null) || usuSession.equals("null")) {
		response.sendRedirect("index.jsp");
	}
	%>
	<div class="PartSuperior">
		<img src="Imagenes/Logo_GOES2.png" alt="GobiernoDeElSalvador"
			class="Logo">
	</div>
	<br>
	<br>
	<div class="Happy">
		<img src="Imagenes/happy.png" alt="Happy" class="happies">
	</div>
	<br>
	<p class="pintro">
		<strong> <%=fullname%>, si eres beneficiario del apoyo
			económico<br> de $300.00 para alimentación de tú hogar.
		</strong>
	</p>
	<br>
	<p class="p2message">
		<strong>Tú pago podrá ser retirado en ventanilla en
			cualquiera de las <br> sucursales del Banco Agrícola de El
			Salvador.
		</strong>
	</p>
	<br>
	<form action="ControllerBeneficiario" method="post">
		<input type="submit" name="soybeneficiario" value="Volver a consultar"
			class="regresar">
	</form>
</body>
</html>