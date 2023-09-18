<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Oficina Mecânica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/cliente/lista"><i class="fas fa-user"></i> Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/alinhamento/lista"><i class="fas fa-cog"></i> Alinhamento</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/manutencao/lista"><i class="fas fa-tools"></i> Manutenção</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/pintura/lista"><i class="fas fa-paint-roller"></i> Pintura</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ordemservico/lista"><i class="fas fa-clipboard"></i> Ordem de Serviço</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/sobre"><i class="fas fa-info-circle"></i> Sobre</a> 
        </li>
      </ul>
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="/usuario/cadastro"><i class="fas fa-user-plus"></i> Registrar-se</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/login"><i class="fas fa-sign-in-alt"></i> Login ${username.email}</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>
