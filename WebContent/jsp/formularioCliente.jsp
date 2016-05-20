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
		<h2>Formulario cliente</h2>		
		<s:form action="accionFormularioCliente" method="POST">
			<s:hidden name="accion" value="%{accion}" />
			<s:if test="accion == \"editar\"">
				<s:textfield name="campoDniDisabled" label="%{getText('label.formulario.cliente.dni')}"
					value="%{dni}" disabled="true" />
				<s:hidden name="dni" value="%{dni}" />
			</s:if>
			<s:else>
				<s:textfield name="dni" label="%{getText('label.formulario.cliente.dni')}"
					value="%{dni}" />
			</s:else>
			<s:textfield name="nombre" label="%{getText('label.formulario.cliente.nombre')}"
				value="%{nombre}" />
			<s:textfield name="apellido" label="%{getText('label.formulario.cliente.apellido')}"
				value="%{apellido}" />
			<s:textfield name="email" label="%{getText('label.formulario.cliente.email')}"
				value="%{email}" />
			<s:textfield name="direccion" label="%{getText('label.formulario.cliente.direccion')}"
				value="%{direccion}" />
			<s:textfield name="codigoPostal" label="%{getText('label.formulario.cliente.codigoPostal')}"
				value="%{codigoPostal}" />
			<s:textfield name="telefono" label="%{getText('label.formulario.cliente.telefono')}"
				value="%{telefono}" />
			<div class="errorSection">
				<tr>
					<td class="error" colspan="2">
						<s:actionerror />
					</td>
				</tr>
			</div>
	    	<s:submit value="%{getText('action.guardar')}"/>
		</s:form>
		<div>&nbsp;</div>
		<s:form action="gestionClientes" method="POST">
		    <s:submit value="%{getText('action.volver')}"/>
		</s:form>
	</body>
</html>