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
	  <h3>Listagem de Pintura:</h3>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Intensidade de Brilho</th>
	        <th>Tinta Ecológica</th>
	        <th>Cor</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   	  
<c:forEach var="p" items="${listaPintura}">
		      <tr>
		        <td>${p.intensidadeBrilho}</td>
		        <td>${p.tintaEcologica}</td>
		        <td>${p.cor}</td>
		        <td><a href="/pintura/${p.cor}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>