<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="application.gestion.alquileres.title"/></title>
		<link rel="icon" type="image/png" href="<s:url value="/img/icon.png"/>" />
		<link type="text/css" rel="stylesheet" href="<s:url value="/css/app.css"/>" />
	</head>
	<body>
		<div class="titleDiv">
			<h1>Centro de llamadas - Propiedades</h1>
		</div>
		<h2>Elige el apartado que deseas gestionar:</h2>
		<s:form action="/jsp/gestionAlquileres.jsp">
		    <s:submit value="%{getText('action.gestion.alquileres')}"/>
		</s:form>
		<s:form action="gestionClientes" method="POST">
		    <s:submit value="%{getText('action.gestion.clientes')}"/>
		</s:form>	
	</body>
</html>