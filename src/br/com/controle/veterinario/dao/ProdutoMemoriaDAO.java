package br.com.controle.veterinario.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.controle.veterinario.Produto;

@Component
public class ProdutoMemoriaDAO implements ProdutoDAO {

	private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoMemoriaDAO() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setDescricao("Mac Book");
		produto.setQuantidade(40);
		
		produtos.add(produto);
	}
	

	@Override
	public void alterar(Produto produto) {
	}

	@Override
	public Produto buscarPorId(Long id) {
		return produtos.get(id.intValue() - 1);
	}

	@Override
	public List<Produto> listar() {
		return produtos;
	}

	@Override
	public void salvar(Produto produto) {
		produtos.add(produto);
		produto.setId(new Integer(produtos.size()).longValue());	//seta o id automaticamente
	}

}
