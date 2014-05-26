package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Usuario;
import br.com.fipgati.eventos.domain.repositorio.UsuarioRepositorio;

@Component
public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioRepositorio {

	public UsuarioDAO(Session session) {
		super(Usuario.class, session);
	}

	public boolean existeUsuario(Usuario usuario) {
		Usuario encontrado = (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("login", usuario.getLogin())).uniqueResult();
		return encontrado != null;
	}
	
	 public Usuario carrega(Usuario usuario) {
		    return (Usuario) session.createCriteria(Usuario.class)
		      .add(Restrictions.eq("login", usuario.getLogin()))
		      .add(Restrictions.eq("senha", usuario.getSenha()))
		      .uniqueResult();
		  }

}
