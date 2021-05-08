<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PANDEMIA COVID-19</title>
<link rel="icon" href="Imagenes/virus.ico">
<link rel="stylesheet" href="Styles/style_nosoybeneficiario.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap"
	rel="stylesheet">
</head>
<body class="bbody">
	<%
	HttpSession sesion = (HttpSession) request.getSession();
	String usuSession = String.valueOf(sesion.getAttribute("nobeneficiario"));
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
	<br>
	<div class="Warning">
		<img src="Imagenes/exclamation.png" alt="Exclamation" class="exclama">
	</div>
	<br>
	<p class="pintro">
		<strong>Este DUI no se encuentra en nuestros registros. <br>Intenta
			ingresando el DUI de otra persona de tu vivienda.
		</strong>
	</p>
	<br>
	<br>
	<form action="ControllerBeneficiario" method="post">
		<input type="submit" name="nosoybeneficiario"
			value="Volver a consultar" class="regresar">
	</form>
</body>
</html>