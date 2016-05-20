<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="application.title"/></title>
		<link rel="icon" type="image/png" href="<s:url value="/img/icon.png"/>" />
		<link type="text/css" rel="stylesheet" href="<s:url value="/css/app.css"/>" />
	</head>
	<body>
		<div class="titleDiv">
			<h1>Centro de llamadas - Propiedades</h1>
		</div>
		<h2>Formulario alquiler</h2>
		<h3>Accion: <s:property value="accion" /></h3>		
		<s:form action="accionFormularioAlquiler" method="POST">
			<s:hidden name="accion" value="%{accion}" />
			<s:hidden name="idAlquiler" value="%{idAlquiler}" />
			<s:hidden name="dniCliente" value="%{txtCliente}" />
			<s:select label="%{getText('label.formulario.alquiler.propiedad')}" 
				headerKey="-1"
				headerValue="Selecciona la propiedad"
				list="propiedades" 
				name="propiedad" />
			<s:select label="%{getText('label.formulario.alquiler.actividad')}" 
				headerKey="-1"
				headerValue="Selecciona la actividad"
				list="actividades" 
				name="actividad" />
			<s:textfield name="fechaInicio" label="%{getText('label.formulario.alquiler.fechaInicio')}"
				value="%{txtFechaInicio}" />
			<s:textfield name="fechaFin" label="%{getText('label.formulario.alquiler.fechaFin')}"
				value="%{txtFechaFin}" />
			<s:textfield name="precio" label="%{getText('label.formulario.alquiler.precio')}"
				value="%{txtPrecio}" />
			<div class="errorSection">
				<tr>
					<td class="error" colspan="2">
						<s:actionerror />
					</td>
				</tr>
			</div>
	    	<s:submit value="%{getText('action.formulario.alquiler')}"/>
		</s:form>
		<div>&nbsp;</div>
		<s:form action="buscarAlquileres" method="POST">
          	<s:hidden name="dniCliente" value="%{txtCliente}" />
		    <s:submit value="%{getText('action.volver')}"/>
		</s:form>
	</body>
</html>