package br.com.controle.veterinario.dao;

import java.util.List;

import br.com.controle.veterinario.Produto;

public interface ProdutoDAO {
	void salvar(Produto produuto);
	void alterar(Produto produto);
	List<Produto> listar();
	Produto buscarPorId(Long id);
}
