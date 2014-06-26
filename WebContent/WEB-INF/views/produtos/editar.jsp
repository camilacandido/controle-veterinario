<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/controle-veterinario/produtos/alterar.html" method="post" commandName="produto">
		<form:hidden path="id" /><br/>
		Descricao: 
		<form:input path="descricao" value="${produto.descricao}" />
		<form:errors path="descricao" /><br/>
		Quantidade: 
		<form:input path="quantidade" value="${produto.quantidade}" />
		<form:errors path="quantidade" /><br/>
		
		<input type="submit" value="Alterar">
	</form:form>
	
</body>
</html>