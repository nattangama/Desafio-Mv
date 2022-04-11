<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
      ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) 
                   request.getAttribute("colaboradores");

%> 

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Desafio MV</title>
<link rel="icon" href="imagens/java-log-icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Café da manhã MV</h1>
	<a href="novo.html" class="Botao1">Novo coladorador</a>
	<table id="tabela">
		<theade>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cpf</th>
			<th>Comida</th>

		</tr>
		</theade>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcolab()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getComida()%></td>

			</tr>
			<%}%>

		</tbody>
	</table>

</body>
</html>