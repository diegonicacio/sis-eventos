package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Organizador;
import br.com.fipgati.eventos.domain.repositorio.OrganizadorRepositorio;

@Component
public class OrganizadorDAO extends GenericDAO<Organizador> implements OrganizadorRepositorio {

	public OrganizadorDAO(Session session) {
		super(Organizador.class, session);
	}
	
}
