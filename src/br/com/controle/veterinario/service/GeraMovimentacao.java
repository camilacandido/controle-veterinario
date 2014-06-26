package br.com.controle.veterinario.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.veterinario.Movimentacao;
import br.com.controle.veterinario.Produto;
import br.com.controle.veterinario.TipoMovimentacao;
import br.com.controle.veterinario.dao.MovimentacaoDAO;

@Service
public class GeraMovimentacao {

	private MovimentacaoDAO movimentacaoDAO;
	
	public GeraMovimentacao() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public GeraMovimentacao(MovimentacaoDAO movimentacaoDAO) {
		this.movimentacaoDAO = movimentacaoDAO;
	}
	
	public void entrada(Produto produto) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setProduto(produto);
		movimentacao.setQuantidade(getQuantidade(produto));
		
		movimentacaoDAO.salvar(movimentacao);
	}
	
	private Integer getQuantidade(Produto produto) {
		Integer quantidade = produto.getQuantidade();
		
		List<Movimentacao> movimentacoes = movimentacaoDAO.getMovimentacoesDo(produto);
		
		for(Movimentacao movimentacao : movimentacoes) {
			if(movimentacao.isEntrada()) {
				quantidade -= movimentacao.getQuantidade();
			}
		}
		
		return quantidade;
	}
}
