<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>

	<div>${mensagem}</div>

	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th colspan="2">Ações</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
		
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.email}</td>
				<td>
					<a href="carrega?id=${usuario.id}">Alterar</a>
					<a href="remove?id=${usuario.id}">Excluir</a>
				</td>	
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>