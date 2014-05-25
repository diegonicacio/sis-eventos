package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Participante;
import br.com.fipgati.eventos.domain.repositorio.ParticipanteRepositorio;

@Component
public class ParticipanteDAO extends GenericDAO<Participante> implements ParticipanteRepositorio{
	
	public ParticipanteDAO(Session session) {
		super(Participante.class, session);
	}

}
