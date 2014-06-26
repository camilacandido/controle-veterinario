package br.com.controle.veterinario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.controle.veterinario.Produto;
import br.com.controle.veterinario.dao.ProdutoDAO;
import br.com.controle.veterinario.service.GeraMovimentacao;

@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {

	@Autowired
	@Qualifier("produtoHibernateDAO")
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private GeraMovimentacao geraMovimentacao;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ModelAndView listar() {
		// dizer para onde vai - caminhos das pastas
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject(produtoDAO.listar());
		return modelAndView;
	}
	
	@RequestMapping(value="/mostrar/{id}", method=RequestMethod.GET)
	public ModelAndView mostrar(@PathVariable Long id) {
		// dizer para onde vai - caminhos das pastas
		ModelAndView modelAndView = new ModelAndView("produtos/mostrar");
		modelAndView.addObject(produtoDAO.buscarPorId(id));
		return modelAndView;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new Produto());	//faz a ligacao do produto da pagina jsp
		return "produtos/form";
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	@Transactional
	public String salvar(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "produtos/form";
		}
		
		produtoDAO.salvar(produto);
		geraMovimentacao.entrada(produto);
		return "redirect:/produtos/listar.html";
	}
	
	@RequestMapping(value="index")
	public String index() {
		// dizer para onde vai - caminhos das pastas
		return "produtos/index";
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.POST)
	@Transactional
	public String alterar(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "produtos/editar";
		}
		
		produtoDAO.alterar(produto);
		geraMovimentacao.entrada(produto);
		return "redirect:/produtos/listar.html";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public ModelAndView editar(Long id) {
		Produto produto = produtoDAO.buscarPorId(id);
		ModelAndView modelAndView = new ModelAndView("produtos/editar");
		modelAndView.addObject(produto);
		return modelAndView;
	}
}
