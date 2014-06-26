package br.com.controle.veterinario.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.controle.veterinario.Movimentacao;
import br.com.controle.veterinario.Produto;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class MovimentacaoHibernateDAO implements MovimentacaoDAO {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public MovimentacaoHibernateDAO(SessionFactory factory) {
		hibernateTemplate = new HibernateTemplate(factory);
	}
	
	public void salvar(Movimentacao movimentacao) {
		hibernateTemplate.save(movimentacao);
		//throw new RuntimeException("erro ao salvar movimentacao");
	}
	
	public List<Movimentacao> getMovimentacoesDo(Produto produto) {
		return hibernateTemplate
				.find("from Movimentacao m where m.produto.id = ?",
					produto.getId());
	}
}
