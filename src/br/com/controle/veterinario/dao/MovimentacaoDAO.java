package br.com.controle.veterinario.dao;

import java.util.List;

import br.com.controle.veterinario.Movimentacao;
import br.com.controle.veterinario.Produto;

public interface MovimentacaoDAO {

	void salvar(Movimentacao movimentacao);
	List<Movimentacao> getMovimentacoesDo(Produto produto);
}
