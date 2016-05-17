<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="application.title"/></title>
		<link rel="icon" type="image/png" href="icon.png" />
		<link type="text/css" rel="stylesheet" href="app.css" />
	</head>
	<body>
		<div class="titleDiv">
			<h1>Centro de llamadas - Propiedades</h1>
		</div>
		<div>
			<h2>Identificaci&oacute;n del cliente</h2>			
		</div>
		<div>
			<s:form action="buscarAlquileres" method="POST">
				<s:textfield name="dniCliente" label="%{getText('label.index.cliente')}"/>
				<div class="errorSection">
					<tr>
						<td class="error" colspan="2">
							<s:actionerror />
						</td>
					</tr>
				</div>
			    <s:submit value="%{getText('label.index.buscar')}"/>
			</s:form>
		</div>	
	</body>
</html>