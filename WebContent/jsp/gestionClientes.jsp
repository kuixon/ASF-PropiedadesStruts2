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
		<h2>Clientes</h2>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="table.clientes.dni"/></th>
		        <th><s:text name="table.clientes.nombre"/></th>
		        <th><s:text name="table.clientes.apellido"/></th>
		        <th><s:text name="table.clientes.email"/></th>
		        <th><s:text name="table.clientes.direccion"/></th>
		        <th><s:text name="table.clientes.codigoPostal"/></th>
		        <th><s:text name="table.clientes.telefono"/></th>
		        <th></th>
		        <th></th>
		        <th>&nbsp;&nbsp;</th>
		    </tr>
		    <s:iterator value="listaClientes" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="dni"/></td>
		            <td class="nowrap"><s:property value="nombre"/></td>
		            <td class="nowrap"><s:property value="apellido"/></td>
		            <td class="nowrap"><s:property value="email"/></td>
		            <td class="nowrap"><s:property value="direccion"/></td>
		            <td class="nowrap"><s:property value="codigoPostal"/></td>
		            <td class="nowrap"><s:property value="telefono"/></td>
		            <td class="nowrap">
		            	<s:form action="formularioCliente" method="POST">
		            		<s:hidden name="accion" value="editar" />
		            		<s:hidden name="dni" value="%{dni}" />
		            		<s:hidden name="nombre" value="%{nombre}" />
		            		<s:hidden name="apellido" value="%{apellido}"/>
		            		<s:hidden name="email" value="%{email}" />
		            		<s:hidden name="direccion" value="%{direccion}" />
		            		<s:hidden name="codigoPostal" value="%{codigoPostal}"/>
		            		<s:hidden name="telefono" value="%{telefono}"/>
						    <s:submit value="%{getText('action.editar')}"/>
						</s:form>
		            </td>
		            <td class="nowrap">
		            	<s:form action="eliminarCliente" method="POST">
		            		<s:hidden name="accion" value="eliminar" />
		            		<s:hidden name="dni" value="%{dni}"/>
						    <s:submit value="%{getText('action.eliminar')}"/>
						</s:form>
		            </td>
		        </tr>
		    </s:iterator>
		</table>
		<div>&nbsp;</div>
		<div>
			<s:form action="formularioCliente" method="POST">
           		<s:hidden name="accion" value="add" />
			    <s:submit value="%{getText('action.addCliente')}"/>
			</s:form>
			<s:form action="/jsp/index.jsp">
			    <s:submit value="%{getText('action.volver')}"/>
			</s:form>
		</div>
	</body>
</html>