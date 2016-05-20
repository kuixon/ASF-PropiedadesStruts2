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
		<h2>Alquileres del cliente con DNI: <s:property value="txtCliente"/></h2>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="table.alquileres.propiedad"/></th>
		        <th><s:text name="table.alquileres.actividad"/></th>
		        <th><s:text name="table.alquileres.fechaInicio"/></th>
		        <th><s:text name="table.alquileres.fechaFin"/></th>
		        <th><s:text name="table.alquileres.precio"/></th>
		        <th></th>
		        <th></th>
		        <th>&nbsp;&nbsp;</th>
		    </tr>
		    <s:iterator value="listaAlquileres" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="propiedad.nombre"/></td>
		            <td class="nowrap"><s:property value="actividad.nombre"/></td>
		            <td class="nowrap"><s:property value="fecha_inicio"/></td>
		            <td class="nowrap"><s:property value="fecha_fin"/></td>
		            <td class="nowrap"><s:property value="precio"/></td>
		            <td class="nowrap">
		            	<s:form action="formularioAlquiler" method="POST">
		            		<s:hidden name="accion" value="editar" />
		            		<s:hidden name="idAlquiler" value="%{idAlquiler}" />
		            		<s:hidden name="txtCliente" value="%{txtCliente}" />
		            		<s:hidden name="txtPropiedad" value="%{propiedad.nombre}" />
		            		<s:hidden name="txtActividad" value="%{actividad.nombre}"/>
		            		<s:hidden name="txtFechaInicio" value="%{fecha_inicio}" />
		            		<s:hidden name="txtFechaFin" value="%{fecha_inicio}" />
		            		<s:hidden name="txtPrecio" value="%{precio}"/>
						    <s:submit value="%{getText('action.editar')}"/>
						</s:form>
		            </td>
		            <td class="nowrap">
		            	<s:form action="eliminarAlquiler" method="POST">
		            		<s:hidden name="accion" value="eliminar" />
		            		<s:hidden name="idAlquiler" value="%{idAlquiler}" />
		            		<s:hidden name="txtCliente" value="%{txtCliente}"/>
						    <s:submit value="%{getText('action.eliminar')}"/>
						</s:form>
		            </td>
		        </tr>
		    </s:iterator>
		</table>
		<div>&nbsp;</div>
		<div>
			<s:form action="formularioAlquiler" method="POST">
           		<s:hidden name="accion" value="add" />
           		<s:hidden name="idAlquiler" value="%{idAlquiler}" />
           		<s:hidden name="txtCliente" value="%{txtCliente}"/>
			    <s:submit value="%{getText('action.añadir')}"/>
			</s:form>
			<s:form action="/jsp/index.jsp">
			    <s:submit value="%{getText('action.volver')}"/>
			</s:form>
		</div>
	</body>
</html>