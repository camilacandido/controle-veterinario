<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Lista de Produtos</title></head>

<body>
	
	<table bgcolor="#C000111" width="600px">
		<tr><td heigth="100px" width="600px"></td></tr> 
		<tr><td><a href="/controle-veterinario/produtos/form.html">Novo</td></tr>
	</table>
			<!-- produtoList => concatenacao do tipo Produto + tipo List -->
			<c:forEach items="${produtoList}" var="produto">
				${produto.descricao} - ${produto.quantidade} -
				<a href="/controle-veterinario/produtos/mostrar/${produto.id}.html" />detalhes</a>
				- <a href="/controle-veterinario/produtos/editar.html?id=${produto.id}">editar</a><br/>
			</c:forEach>
		
</body>
</html>