<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="application.gestion.clientes.title"/></title>
		<link rel="icon" type="image/png" href="<s:url value="/img/icon.png"/>" />
		<link type="text/css" rel="stylesheet" href="<s:url value="/css/app.css"/>" />
	</head>
	<body>
		<div class="titleDiv">
			<h1>Centro de llamadas - Propiedades</h1>
		</div>
		<s:if test="accion == \"add\"">
			<h2>El cliente con dni <s:property value="%{dni}" /> ha sido añadido correctamente</h2>
		</s:if>
		<s:elseif test="accion == \"eliminar\"">
		    <h2>El cliente con dni <s:property value="%{dni}" /> ha sido eliminado correctamente</h2>
		</s:elseif>
		<s:elseif test="accion == \"editar\"">
		    <h2>El cliente con dni <s:property value="%{dni}" /> ha sido editado correctamente</h2>
		</s:elseif>
		<s:form action="gestionClientes" method="POST">
		    <s:submit value="%{getText('action.volver')}"/>
		</s:form>
	</body>
</html>