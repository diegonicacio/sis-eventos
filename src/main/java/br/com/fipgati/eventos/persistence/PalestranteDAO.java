package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Palestrante;
import br.com.fipgati.eventos.domain.repositorio.PalestranteRepositorio;

@Component
public class PalestranteDAO extends GenericDAO<Palestrante> implements PalestranteRepositorio{

	public PalestranteDAO(Session session) {
		super(Palestrante.class, session);
	}
	
}
