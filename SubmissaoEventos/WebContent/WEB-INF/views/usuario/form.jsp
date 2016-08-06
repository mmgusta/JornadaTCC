<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar - Usuário</title>
</head>
<spring:form method="post" action="/usuario/cadastro" modelAttribute="usuario">
	<div>
		<label for="nome">Nome:</label>
		<spring:input path="nome"/>
	</div>
	<div>
		<label for="email">E-mail:</label>
		<spring:input path="email"/>
	</div>
	<div>
		<label for="senha">Senha:</label>
		<spring:password path="senha"/>
	</div>
	<div>
		<input type="submit" value="Cadastrar"/>
	</div>
	
</spring:form>
</html>