<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>

<h1>Para modificar un registro Pulsa sobre un registro en la tabla de clientes</h1><br><br><br><br>

<table>

	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Email</th>
		
		<th>Eliminar</th>
	
	</tr>
	
	<c:forEach var="clienteTemp" items="${clientes}">
	
	<c:url var="linkEliminar" value="/cliente/eliminar">
	
	
		<c:param name="id" value="${clienteTemp.id}"/>
	
	</c:url>
						<!-- redirecciona a este metodo -->
	<tr>
		<td onclick="window.location.href='${pageContext.request.contextPath}/cliente/actualizaRegistrosTabla?idCliente=${clienteTemp.id}'">${clienteTemp.nombre}</td>
		<td onclick="window.location.href='${pageContext.request.contextPath}/cliente/actualizaRegistrosTabla?idCliente=${clienteTemp.id}'">${clienteTemp.apellido}</td>
		<td onclick="window.location.href='${pageContext.request.contextPath}/cliente/actualizaRegistrosTabla?idCliente=${clienteTemp.id}'">${clienteTemp.email}</td>
	
			<!-- Para configuar el boton de eliminar. -->
		<td>
    		<a href="${linkEliminar}" onclick="return confirm('¿Quieres eliminar este registro?')">
        	<input type="button" value="Eliminar"/>
    		</a>
		</td>
	</tr>
	
	</c:forEach>

</table>


<br/>
													<!-- redirecciona a este metodo -->
<input type="button" value="Agregar cliente" onclick="window.location.href='muestraFormularioAgregar'; return false;"/><br/>

</body>
</html>