package br.com.controle.veterinario.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.controle.veterinario.Usuario;

@Repository
public class UsuarioHibernateDAO implements UsuarioDAO {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public UsuarioHibernateDAO (SessionFactory factory) {
		hibernateTemplate = new HibernateTemplate(factory);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		List usuarios = hibernateTemplate.find("from Usuario where login = ?", username);
		
		if(!usuarios.isEmpty()) {
			return (Usuario) usuarios.get(0);
		}
		
		return null;
	}
	
	public UserDetails loadUserByUsernameUserDetails(String username, String filial)
			throws UsernameNotFoundException, DataAccessException {
		
		List usuarios = hibernateTemplate.find("from Usuario where login = ? and filial = ?", 
				new Object[]{username, filial});
		
		if(!usuarios.isEmpty()) {
			return (Usuario) usuarios.get(0);
		}
		
		return null;
	}

}
