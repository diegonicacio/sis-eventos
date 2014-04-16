package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Palestra;
import br.com.fipgati.eventos.domain.repositorio.PalestraRepositorio;

@Component
public class PalestraDAO extends GenericDAO<Palestra> implements PalestraRepositorio{

	public PalestraDAO(Session session) {
		super(Palestra.class, session);
	}
}
