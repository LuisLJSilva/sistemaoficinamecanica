<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Oficina Mecânica</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container-fluid mt-3">
	  <h3>Listagem de Alinhamento:</h3>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Ajuste de Cambagem</th>
	        <th>Freios Verificados</th>
	        <th>Condição dos Pneus</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   	  
<c:forEach var="a" items="${listaAlinhamento}">
		      <tr>
		        <td>${a.ajusteCambagem}</td>
		        <td>${a.freiosVerificados}</td>
		        <td>${a.condicaoPneus}</td>
		        <td><a href="/alinhamento/${a.condicaoPneus}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>