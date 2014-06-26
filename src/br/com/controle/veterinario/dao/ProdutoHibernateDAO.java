package br.com.controle.veterinario.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.controle.veterinario.Produto;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class ProdutoHibernateDAO implements ProdutoDAO {

	//private Session session;
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public ProdutoHibernateDAO(SessionFactory factory) {
		//session = factory.openSession();
		hibernateTemplate = new HibernateTemplate(factory);
	}
	
	public List<Produto> listar() {
		//List<Produto> produtos = session.createQuery("from Produto").list();
		List<Produto> produtos = hibernateTemplate.find("from Produto");
		return produtos;
	}
	
	public void salvar(Produto produto) {
		//session.save(produto);
		hibernateTemplate.save(produto);
	}
	
	public Produto buscarPorId(Long id) {
		//return (Produto) session.get(Produto.class, id);
		return hibernateTemplate.get(Produto.class, id);
	}
	
	public void alterar(Produto produto) {
		//session.update(produto);
		hibernateTemplate.update(produto);
	}
}
