package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Participante;
import br.com.fipgati.eventos.domain.repositorio.InscritoRepositorio;

@Component
public class InscritoDAO extends GenericDAO<Participante> implements InscritoRepositorio{
	
	public InscritoDAO(Session session) {
		super(Participante.class, session);
	}

}
