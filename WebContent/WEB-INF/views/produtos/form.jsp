<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head><title>Cadastro de Produtos</title></head>

<body>
	
	<form:form action="/controle-veterinario/produtos/salvar.html" method="post" commandName="produto">
		Descricao: <form:input path="descricao" /><form:errors path="descricao" /><br>
		Quantidade: <form:input path="quantidade" /><form:errors path="quantidade" /><br>
		<input type="submit" value="Cadastrar">
	</form:form>
	
</body>
</html>